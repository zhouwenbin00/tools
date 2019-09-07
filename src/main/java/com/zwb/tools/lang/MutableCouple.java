package com.zwb.tools.lang;


import com.zwb.tools.annotation.Nullable;

/**
 * 可变的一对
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 11:07
 */
public class MutableCouple<L, R> implements Couple<L, R> {
    private L left;
    private R right;

    public MutableCouple(@Nullable L left, @Nullable R right) {
        this.left = left;
        this.right = right;
    }

    public MutableCouple() {
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
        return this.right = value;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public void setRight(R right) {
        this.right = right;
    }
}
