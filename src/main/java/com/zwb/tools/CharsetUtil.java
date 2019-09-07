package com.zwb.tools;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 字符集工具
 * @Auther: zhouwenbin
 * @Date: 2019/8/29 21:15
 */
public class CharsetUtil {

    /** ISO-8859-1 */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /** UTF-8 */
    public static final String UTF_8 = "UTF-8";
    /** GBK */
    public static final String GBK = "GBK";

    /** ISO-8859-1 */
    public static final Charset CHARSET_ISO_8859_1 = StandardCharsets.ISO_8859_1;
    /** UTF-8 */
    public static final Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;
    /** GBK */
    public static final Charset CHARSET_GBK = Charset.forName(GBK);
}
