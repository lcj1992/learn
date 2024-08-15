package circuit_breaker;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class SimpleCircuitBreakerTest {

    @Test
    public void test() {
        SimpleCircuitBreaker breaker = new SimpleCircuitBreaker(3, 10);
        Runnable serviceCall = () -> {
            // 模拟远程服务调用，这里我们简单地抛出异常来模拟失败
            if (Math.random() < 0.5) {
                throw new RuntimeException("Simulated service failure");
            }
        };

        for (int i = 0; i < 10; i++) {
            if (breaker.tryCall(serviceCall)) {
                System.out.println("Call successful");
            } else {
                System.out.println("Circuit is open, call failed");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static class SimpleCircuitBreaker {
        private final Queue<LocalDateTime> recentFailures = new LinkedList<>();
        private final int failureThreshold;
        private final Duration resetDuration;
        private boolean isCircuitOpen = false;
        private LocalDateTime lastFailureTime;

        public SimpleCircuitBreaker(int failureThreshold, int resetDurationSeconds) {
            this.failureThreshold = failureThreshold;
            this.resetDuration = Duration.ofSeconds(resetDurationSeconds);
        }

        /**
         * 尝试调用远程服务。如果断路器打开，则立即返回false，
         * 否则尝试调用并更新断路器状态。
         *
         * @return true如果调用成功或断路器关闭，false如果断路器打开。
         */
        public boolean tryCall(Runnable serviceCall) {
            if (isCircuitOpen && LocalDateTime.now().isBefore(lastFailureTime.plus(resetDuration))) {
                // 断路器打开并且还在重置窗口内，直接返回失败
                return false;
            }
            try {
                serviceCall.run();
                cleanUpOldFailures();
                return true;
            } catch (Exception e) {
                handleFailure();
                return false;
            }
        }

        /**
         * 处理失败情况，更新最近的失败记录。
         */
        private void handleFailure() {
            recentFailures.add(LocalDateTime.now());
            if (recentFailures.size() >= failureThreshold) {
                // 达到失败阈值，打开断路器
                isCircuitOpen = true;
                lastFailureTime = LocalDateTime.now();
            }
        }

        /**
         * 清理过期的失败记录。
         */
        private void cleanUpOldFailures() {
            recentFailures.removeIf(time -> LocalDateTime.now().minus(resetDuration).isAfter(time));
        }
    }
}