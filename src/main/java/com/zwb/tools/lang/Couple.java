package com.zwb.tools.lang;

import com.zwb.tools.annotation.Nullable;

import java.util.Map;

/**
 * 一对
 *
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 11:03
 */
public interface Couple<L, R> extends Map.Entry<L, R> {
    static <L, R> Couple<L, R> ofImmutable(L left, R right) {
        return new ImmutableCouple<>(left, right);
    }

    @Nullable
    L getLeft();

    @Nullable
    R getRight();

}
