package com.zwb.tools.annotation;

import java.lang.annotation.*;

/**
 * 表示类或方法不是线程安全的
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 11:02
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ThreadUnsafe {
}
