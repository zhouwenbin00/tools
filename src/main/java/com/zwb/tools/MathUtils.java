package com.zwb.tools;


/**
 * @Auther: zhouwenbin
 * @Date: 2019/9/7 14:37
 */
public class MathUtils {

    public static int safeValue(int v, int min, int max) {
        return v > max ? max : v < min ? min : v;
    }

    /**
     * 安全相加,如果越界返回int最大值
     *
     * @param x
     * @param y
     * @return
     */
    public static int safeAdd(int x, int y) {
        int r = x + y;
        if (((x ^ r) & (y ^ r)) < 0) {
            return Integer.MAX_VALUE;
        }
        return r;
    }
}
