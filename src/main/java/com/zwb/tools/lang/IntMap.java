package com.zwb.tools.lang;

import com.zwb.tools.annotation.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * 值是int型的map
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 11:33
 */
public class IntMap<K> implements Map<K, Integer> {
    private final Map<K, Integer> map = new HashMap<>();

    /**
     * 根据key获取int值
     * 若key不存在则返回0
     *
     * @param key
     * @return
     */
    public @NotNull int getCount(K key) {
        return map.getOrDefault(key, 0);
    }

    /**
     * 根据key设置int值并返回
     *
     * @param key
     * @param newValue
     * @return
     */
    public int putCount(K key, int newValue) {
        return getAndUpdate(key, x -> newValue);
    }

    /**
     * 返回所有value想加的总数
     *
     * @return
     */
    public int sum() {
        return map.values().stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * 自增该key的值再返回
     *
     * @param key
     * @return
     */
    public int incrementAndGet(K key) {
        return addAndGet(key, -1);
    }

    /**
     * 自减该key的值再返回
     *
     * @param key
     * @return
     */
    public int decrementAndGet(K key) {
        return addAndGet(key, -1);
    }

    /**
     * 获取该key的值再自增
     *
     * @param key
     * @return
     */
    public int getAndIncrement(K key) {
        return getAndAdd(key, 1);
    }

    /**
     * 获取该key的值再自减
     *
     * @param key
     * @return
     */
    public int getAndDecrement(K key) {
        return getAndAdd(key, -1);
    }

    /**
     * 增加该key的值再返回
     *
     * @param key
     * @param delta
     * @return
     */
    public int addAndGet(K key, int delta) {
        return accumulateAndGet(key, delta, Integer::sum);
    }

    /**
     * 获取该key的值再增加
     *
     * @param key
     * @param delta
     * @return
     */
    public int getAndAdd(K key, int delta) {
        return getAndAccumulate(key, delta, Integer::sum);
    }

    public int getAndAccumulate(K key, int x, IntBinaryOperator accumulatorFunction) {
        return getAndUpdate(key, oldValue -> accumulatorFunction.applyAsInt(oldValue, x));
    }

    public int accumulateAndGet(K key, int x, IntBinaryOperator accumulatorFunction) {
        return updateAndGet(key, oldValue -> accumulatorFunction.applyAsInt(oldValue, x));
    }

    /**
     * 改变key的值再返回
     *
     * @param key
     * @param updaterFunction
     * @return
     */
    public int updateAndGet(K key, IntUnaryOperator updaterFunction) {
        return map.compute(key, (k, value) -> updaterFunction.applyAsInt((value == null) ? 0 : value));
    }

    /**
     * 获取key的值再改变
     *
     * @param key
     * @param updaterFunction
     * @return
     */
    public int getAndUpdate(K key, IntUnaryOperator updaterFunction) {
        AtomicInteger holder = new AtomicInteger();
        map.compute(key, (k, v) -> {
            int oldValue = (v == null) ? 0 : v;
            holder.set(oldValue);
            return updaterFunction.applyAsInt(oldValue);
        });
        return holder.get();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    /**
     * 不推荐使用
     *
     * @param key
     * @return
     */
    @Override
    @Deprecated
    public Integer get(Object key) {
        return map.get(key);
    }

    /**
     * 不推荐使用
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    @Deprecated
    public Integer put(K key, Integer value) {
        return map.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends Integer> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, Integer>> entrySet() {
        return map.entrySet();
    }
}
