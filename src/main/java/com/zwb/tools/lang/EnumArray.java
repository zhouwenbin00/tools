package com.zwb.tools.lang;

import com.zwb.tools.AssertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 枚举数组
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 10:25
 */
public class EnumArray<E extends Enum<E>, T> {
    protected final T[] array;
    protected final Class<E> c;

    public EnumArray(Class<E> c) {
        this.array = (T[]) new Object[c.getEnumConstants().length];
        this.c = c;
    }

    public static <E extends Enum<E>, T> EnumArray<E, T> create(Class<E> c) {
        return new EnumArray<>(c);
    }

    /**
     * 根据枚举获取值
     * @param index
     * @return
     */
    public T get(E index) {
        return get(index.ordinal());
    }

    /**
     * 根据索引获取值
     * 调用者自行保证安全
     * @param index
     * @return
     */
    @Deprecated
    public T get(int index) {
        if (index < 0 || index > array.length - 1) {
            return null;
        }
        return array[index];
    }

    /**
     * 根据枚举设置值
     * @param index
     * @param object
     * @return
     */
    public T set(E index, T object) {
        return this.set(index.ordinal(), object);
    }

    /**
     * 根据索引设置值
     * 调用者自行保证安全
     * @param index
     * @param object
     * @return
     */
    @Deprecated
    public T set(int index, T object) {
        T old = this.array[index];
        this.array[index] = object;
        return old;
    }

    /**
     * 确保所有值不为空
     */
    public void makeSureNoNull() {
        for (int i = 0; i < this.array.length; i++) {
            AssertUtils.notNull(this.array[i], "{} is null", i);
        }
    }

    /**
     * 内容长度
     * @return
     */
    public int size() {
        return this.array.length;
    }

    /**
     * 根据枚举获取值，如果为空则返回默认
     * @param index
     * @param v
     * @return
     */
    public T getOrDefault(E index, T v) {
        T t = this.get(index.ordinal());
        if (t == null) {
            t = v;
            this.set(index, v);
        }
        return t;
    }

    /**
     * forEach
     * @param action
     */
    public void forEach(Consumer<T> action) {
        AssertUtils.notNull(action);
        for (T t : this.array) {
            action.accept(t);
        }
    }

    /**
     * 转成list
     * @return
     */
    public List<T> toList() {
        List<T> list = new ArrayList<>(this.size());
        for (E e : this.c.getEnumConstants()) {
            list.add(this.get(e));
        }
        return list;
    }

    /**
     * 转成数组
     * @return
     */
    public T[] toArrary() {
        return Arrays.copyOf(this.array, this.size());
    }

    /**
     * 全部值设置为T
     * @param supplier
     * @return
     */
    public EnumArray<E, T> allSet(Supplier<T> supplier) {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = supplier.get();
        }
        return this;
    }


}
