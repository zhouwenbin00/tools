package com.zwb.tools.lang;


import com.zwb.tools.annotation.ThreadSafe;

/**
 * 不可变的俩
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 11:04
 */
@ThreadSafe
public class ImmutableCouple<L, R> implements Couple<L, R> {

    private final L left;
    private final R right;

    public ImmutableCouple(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public L getLeft() {
        return this.left;
    }

    @Override
    public R getRight() {
        return this.right;
    }

    @Override
    public L getKey() {
        return getLeft();
    }

    @Override
    public R getValue() {
        return getRight();
    }

    @Override
    public R setValue(R value) {
        throw new UnsupportedOperationException();
    }
}
