package concurrent;

import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/25
 * Time: 上午11:27
 */
public class Mutex {

    private class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 7133560559976795777L;

        @Override
        protected boolean tryAcquire(int ignore) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int ignore) {
            setState(0);
            return true;
        }
    }

    private final Sync sync = new Sync();

    private void lock() {
        sync.acquire(0);
    }

    private void unlock() {
        sync.release(0);
    }


    @Test
    public void test(){
        Mutex mutex = new Mutex();
        mutex.lock();
        mutex.unlock();
    }
}
