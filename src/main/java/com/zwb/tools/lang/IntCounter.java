package com.zwb.tools.lang;


import com.zwb.tools.AssertUtils;
import com.zwb.tools.MathUtils;

/**
 * 计数器
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 14:33
 */
public class IntCounter {
    private int count;

    public IntCounter(int initValue) {
        AssertUtils.isTrue(initValue >= low() && initValue <= high(), "low<=initValue<=high");
        setCount(initValue);
    }


    public IntCounter() {
    }

    /**
     * 清0
     */
    public void zero() {
        setCount(0);
    }

    /**
     * 设置为最大值
     */
    public void setHigh() {
        setCount(high());
    }

    /**
     * 设置为最小值
     */
    public void setLow() {
        setCount(low());
    }

    /**
     * 最小限制
     *
     * @return
     */
    protected int low() {
        return 0;
    }

    protected int high() {
        return Integer.MAX_VALUE;
    }

    /**
     * 获取当前值
     *
     * @return
     */
    public int getCount() {
        return this.count;
    }

    /**
     * 设置值
     *
     * @param value
     * @return
     */
    public int setCount(int value) {
        return this.count = MathUtils.safeValue(value, low(), high());
    }

    /**
     * +1并获取
     *
     * @return
     */
    public int incrementAndGet() {
        return addAndGet(1);
    }

    /**
     * -1并获取
     *
     * @return
     */
    public int decrementAndGet() {
        return addAndGet(-1);
    }

    /**
     * 增加并获取
     *
     * @param delta
     * @return
     */
    public int addAndGet(int delta) {
        return setCount(MathUtils.safeAdd(getCount(), delta));
    }

    /**
     * 获取并+1
     *
     * @return
     */
    public int getAndIncrement() {
        return getAndAdd(1);
    }

    /**
     * 获取并-1
     *
     * @return
     */
    public int getAndDecrement() {
        return getAndAdd(-1);
    }

    /**
     * 获取并增加
     *
     * @param delta
     * @return
     */
    public int getAndAdd(int delta) {
        int old = getCount();
        setCount(MathUtils.safeAdd(old, delta));
        return old;
    }

    /**
     * 是否到达下边界
     *
     * @return
     */
    public boolean reachLow() {
        return count == low();
    }

    /**
     * 是否到达上边界
     *
     * @return
     */
    public boolean reachHigh() {
        return count == high();
    }

}
