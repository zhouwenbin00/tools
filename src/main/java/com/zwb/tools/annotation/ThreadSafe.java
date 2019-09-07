package com.zwb.tools.annotation;

import java.lang.annotation.*;

/**
 * 表示为线程安全的类或者方法
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 11:02
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface ThreadSafe {
}
