import com.sun.xml.internal.ws.util.UtilException;

import java.util.Arrays;

/**
 * 数组工具
 *
 * @Auther: zhouwenbin
 * @Date: 2019/8/29 21:04
 */
public class ArrayUtils {

    /**
     * 判断是否为空
     * @param array
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(final T... array) {
        return array == null || array.length == 0;
    }


    /**
     * 对象是否为数组对象
     *
     * @param obj 对象
     * @return 是否为数组对象，如果为{@code null} 返回false
     */
    public static boolean isArray(Object obj) {
        if (null == obj) {
            // throw new NullPointerException("Object check for isArray is null");
            return false;
        }
        return obj.getClass().isArray();
    }

    public static String toString(Object obj) {
        if (null == obj) {
            return null;
        }
        if (ArrayUtils.isArray(obj)) {
            try {
                return Arrays.deepToString((Object[]) obj);
            } catch (Exception e) {
                final String className = obj.getClass().getComponentType().getName();
                switch (className) {
                    case "long":
                        return Arrays.toString((long[]) obj);
                    case "int":
                        return Arrays.toString((int[]) obj);
                    case "short":
                        return Arrays.toString((short[]) obj);
                    case "char":
                        return Arrays.toString((char[]) obj);
                    case "byte":
                        return Arrays.toString((byte[]) obj);
                    case "boolean":
                        return Arrays.toString((boolean[]) obj);
                    case "float":
                        return Arrays.toString((float[]) obj);
                    case "double":
                        return Arrays.toString((double[]) obj);
                    default:
                        throw new UtilException(e);
                }
            }
        }
        return obj.toString();
    }

}
