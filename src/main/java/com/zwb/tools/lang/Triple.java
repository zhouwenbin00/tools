package com.zwb.tools.lang;

import com.zwb.tools.annotation.Nullable;

/**
 * 仨
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 13:43
 */
public interface Triple<L, M, R> {
    static <L, M, R> Triple<L, M, R> ofImmutable(L left, M middle, R right) {
        return new ImmutableTriple<>(left, middle, right);
    }

    @Nullable
    L getLeft();

    @Nullable
    M getMiddle();

    @Nullable
    R getRight();
}
