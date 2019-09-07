package com.zwb.tools;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * 字符串工具类
 *
 * @Auther: zhouwenbin
 * @Date: 2019/8/29 20:17
 */
public class StringUtils {

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    public StringUtils() {
        super();
    }

    /**
     * 检查字符串是否为null或者""
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    /**
     * 检查字符串是否为null,""或者是空白的。
     *
     * @param str
     * @return boolean
     */
    public static boolean isBlank(CharSequence str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            // 只要有一个非空字符即为非空字符串
            if (!CharUtil.isNotBlank(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }


    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    /**
     * 格式化文本, {} 表示占位符
     *
     * @param template
     * @param params
     * @return
     */
    public static String format(CharSequence template, Object... params) {
        if (null == template) {
            return null;
        }
        if (ArrayUtils.isEmpty(params) || isBlank(template)) {
            return template.toString();
        }
        return StrFormatter.format(template.toString(), params);

    }

    public static String utf8Str(Object obj) {
        return str(obj, CharsetUtil.CHARSET_UTF_8);
    }

    public static String str(Object obj, String charsetName) {
        return str(obj, Charset.forName(charsetName));
    }

    public static String str(Object obj, Charset charset) {
        if (null == obj) {
            return null;
        }

        if (obj instanceof String) {
            return (String) obj;
        } else if (obj instanceof byte[]) {
            return str((byte[]) obj, charset);
        } else if (obj instanceof Byte[]) {
            return str((Byte[]) obj, charset);
        } else if (obj instanceof ByteBuffer) {
            return str((ByteBuffer) obj, charset);
        } else if (ArrayUtils.isArray(obj)) {
            return ArrayUtils.toString(obj);
        }

        return obj.toString();
    }


}
