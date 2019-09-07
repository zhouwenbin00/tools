package com.zwb.tools.lang;


import com.zwb.tools.annotation.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 13:53
 */
public interface Table<R, C, V> {
    boolean contains(@Nullable R row, @Nullable C column);

    boolean containsRow(@Nullable R row);

    boolean containsColumn(@Nullable C column);

    boolean containsValue(@Nullable V value);

    V get(R row, C column);

    boolean isEmpty();

    int size();

    void clear();

    void putAll(Table<? extends R, ? extends C, ? extends V> table);

    V remove(R row, C column);

    Map<C, V> row(R row);

    Map<R, V> column(C column);

    Set<R> rowKeySet();

    Set<C> columnKeySet();

    Collection<V> values();

    Map<R, Map<C, V>> rowMap();

    Map<C, Map<R, V>> columnMap();

}
