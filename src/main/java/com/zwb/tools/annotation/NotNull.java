package com.zwb.tools.annotation;

import java.lang.annotation.*;

/**
 * 标记某参数或返回值不为空
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 10:59
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface NotNull {
}
