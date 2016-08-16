/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/4
 * Time: 上午11:17
 */
package com.meituan.mtkit.utils.sequence;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自增id生成器
 * Created by dennis on 15/8/31.
 */
public class Sequence {
    /**
     * 处理器位数，8位默认支持255个处理器
     */
    private long workerIdBits = 8;
    /**
     * 根据位数算出的的最大处理器个数
     */
    private long maxWorker = -1l ^ (-1l << workerIdBits);
    /**
     * 单个时间周期内最多生成的序列号位数，默认为2(0-3)，
     */
    private long sequenceBits = 2L;
    /**
     * 序列号掩码
     */
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 计算得出的时间戳位偏移
     */
    private long timestampLeftShift = sequenceBits + workerIdBits;

    /**
     * 计时器
     */
    private volatile long lastTimestamp = -1;

    /**
     * 序列号生成器
     */
    private AtomicReference<AtomicLong> sequence = new AtomicReference<AtomicLong>(new AtomicLong(-1));
    //private AtomicLong sequence = new AtomicLong(0);
    /**
     * 基准时间点
     */
    private long originEpoch = 1415065374657l;
    /**
     * 根据处理单元编号计算的位掩码
     */
    private final long workerBits;

    public Sequence(long workerId) {
        if (workerId > maxWorker || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorker));
        }
        this.workerBits = workerId << sequenceBits;
    }

    /* 抛弃有锁实现
    public synchronized long nextIdSync() {

        long timestamp = currentTimeMillions();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            simpleSequence = (simpleSequence + 1) & sequenceMask;
            if (simpleSequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            simpleSequence = 0;
        }

        lastTimestamp = timestamp;
        return ((timestamp - originEpoch) << timestampLeftShift) | workerBits | simpleSequence;


    }*/

    public long nextId() {
        long currentSeq, seq, timestamp;
        timestamp = currentTimeMillions();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }
        for(; ; ) {
            AtomicLong localSequence = sequence.get();
            if (lastTimestamp == timestamp) {
                currentSeq = localSequence.incrementAndGet();
                if (currentSeq > sequenceMask) { //当前毫秒的已经用完，计数器清0，等到下一个毫秒
                    timestamp = tilNextMillis(lastTimestamp);
                    updateSequenceEpoch(localSequence);
                    continue;
                } else {
                    seq = currentSeq & sequenceMask;
                    break;
                }
            }
            lastTimestamp = timestamp;
        }
        System.out.println(timestamp);
        return ((timestamp - originEpoch) << timestampLeftShift) | this.workerBits | seq;
    }

    private boolean updateSequenceEpoch(AtomicLong localSequence) {
        return sequence.compareAndSet(localSequence, new AtomicLong(-1));
    }

    public static long asTimestamp(long id, long timestampLeftShift, long originEpoch) {
        long mask = id >> timestampLeftShift;
        return mask + originEpoch;
    }

    public static long asWorkerId(long id, long sequenceBits, long workerIdBits) {
        long mask = id >> sequenceBits & ((1 << workerIdBits) - 1);
        return mask;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long nextMillion = lastTimestamp;
        long timestamp = currentTimeMillions();
        while (timestamp <= nextMillion) {
            timestamp = currentTimeMillions();
        }
        return timestamp;
    }

    protected long currentTimeMillions() {
        return System.currentTimeMillis();
    }

    public long getWorkerIdBits() {
        return workerIdBits;
    }

    public long getSequenceBits() {
        return sequenceBits;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(16);
        long id = sequence.nextId();
        System.out.println("id=" + id);
        System.out.println(asTimestamp(id, sequence.timestampLeftShift, sequence.originEpoch));
        System.out.println(asWorkerId(id, sequence.sequenceBits, sequence.workerIdBits));
    }
}

