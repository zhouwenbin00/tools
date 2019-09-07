package com.zwb.tools;

/**
 * 字符串格式化工具
 * @Auther: zhouwenbin
 * @Date: 2019/8/29 21:03
 */
public class StrFormatter {

    private static final String delim = "{}";

    public static String format(final String templete, final Object... params) {
        if (StringUtils.isBlank(templete) || ArrayUtils.isEmpty(params)) {
            return templete;
        }
        final int length = templete.length();
        // 初始化定义好的长度以获得更好的性能
        StringBuilder sb = new StringBuilder(length + 50);
        int handledPosition = 0;// 记录已经处理到的位置
        int delimIndex;// 占位符所在位置
        for (int i = 0; i < params.length; i++) {
            delimIndex = templete.indexOf(delim, handledPosition);
            if (delimIndex == -1) {
                if (handledPosition == 0) {
                    return templete;
                }
                sb.append(templete, handledPosition, length);
                return sb.toString();
            }
            if (delimIndex > 0 && templete.charAt(delimIndex - 1) == CharUtil.BACKSLASH) {//转义符号
                if (delimIndex > 1 && templete.charAt(delimIndex - 2) == CharUtil.BACKSLASH) {// 双转义符
                    // 转义符之前还有一个转义符，占位符依旧有效
                    sb.append(templete, handledPosition, delimIndex - 1);
                    sb.append(StringUtils.utf8Str(params[i]));
                    handledPosition = delimIndex + 2;
                } else {
                    // 占位符被转义
                    i--;
                    sb.append(templete, handledPosition, delimIndex - 1);
                    sb.append(CharUtil.DELIM_START);
                    handledPosition = delimIndex + 1;
                }
            } else {// 正常占位符
                sb.append(templete, handledPosition, delimIndex);
                sb.append(StringUtils.utf8Str(params[i]));
                handledPosition = delimIndex + 2;
            }


        }
        sb.append(templete, handledPosition, templete.length());
        // 加入最后一个占位符后所有的字符
        return sb.toString();
    }
}
