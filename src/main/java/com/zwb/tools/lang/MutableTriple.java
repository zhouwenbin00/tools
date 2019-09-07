package com.zwb.tools.lang;

/**
 * 可变的仨
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 13:49
 */
public class MutableTriple<L, M, R> implements Triple<L, M, R> {

    private L left;
    private M middle;
    private R right;

    public MutableTriple(L left, M middle, R right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public MutableTriple() {
    }

    @Override
    public L getLeft() {
        return this.left;
    }

    @Override
    public M getMiddle() {
        return this.middle;
    }

    @Override
    public R getRight() {
        return this.right;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public void setMiddle(M middle) {
        this.middle = middle;
    }

    public void setRight(R right) {
        this.right = right;
    }
}
