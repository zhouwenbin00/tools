package com.zwb.tools.annotation;

import java.lang.annotation.*;

/**
 * 标记某参数或返回值可能为空
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 11:00
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface Nullable {
}
