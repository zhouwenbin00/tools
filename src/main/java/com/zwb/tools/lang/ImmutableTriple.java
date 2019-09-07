package com.zwb.tools.lang;


import com.zwb.tools.annotation.Nullable;
import com.zwb.tools.annotation.ThreadSafe;

/**
 * 不可变的仨
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 13:44
 */
@ThreadSafe
public class ImmutableTriple<L, M, R> implements Triple<L, M, R> {
    private final L left;
    private final M middle;
    private final R right;

    public ImmutableTriple(@Nullable L left, @Nullable M middle, @Nullable R right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
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
}
