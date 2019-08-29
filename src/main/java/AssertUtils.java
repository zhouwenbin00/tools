
/**
 * 断言工具
 *
 * @Auther: zhouwenbin
 * @Date: 2019/8/29 20:55
 */
public class AssertUtils {

    public AssertUtils() {
    }

    /**
     * 断言条件为真， 如果false则抛出异常
     *
     * @param condition
     * @param errorMsgTemplate
     * @param params
     */
    public static void isTrue(boolean condition, String errorMsgTemplate, Object... params) {
        if (!condition) {
            throw new IllegalArgumentException(StringUtils.format(errorMsgTemplate, params));
        }

    }

    public static void isTrue(boolean condition) throws IllegalArgumentException {
        isTrue(condition, "[Assertion failed] - this condition must be true");
    }

    /**
     * 断言条件为假,如果true则抛出异常
     *
     * @param condition
     * @param errorMsgTemplate
     * @param params
     * @throws IllegalArgumentException
     */
    public static void isFalse(boolean condition, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        if (condition) {
            throw new IllegalArgumentException(StringUtils.format(errorMsgTemplate, params));
        }
    }

    public static void isFalse(boolean condition) throws IllegalArgumentException {
        isFalse(condition, "[Assertion failed] - this condition must be false");
    }

    /**
     * 断言对象为空，不为空则抛出异常
     * @param object
     * @param errorMsgTemplate
     * @param params
     * @throws IllegalArgumentException
     */
    public static void isNull(Object object, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        if (object != null) {
            throw new IllegalArgumentException(StringUtils.format(errorMsgTemplate, params));
        }
    }

    public static void isNull(Object object) throws IllegalArgumentException {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    /**
     * 断言对象不为空，为空则抛出异常
     * @param object
     * @param errorMsgTemplate
     * @param params
     * @param <T>
     * @return
     * @throws IllegalArgumentException
     */
    public static <T> T notNull(T object, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException(StringUtils.format(errorMsgTemplate, params));
        }
        return object;
    }

    public static <T> T notNull(T object) throws IllegalArgumentException {
        return notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    /**
     * 断言字符串不为空，为空则抛出异常
     * @param text
     * @param errorMsgTemplate
     * @param params
     * @return
     * @throws IllegalArgumentException
     */
    public static String notEmpty(String text, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException(StringUtils.format(errorMsgTemplate, params));
        }
        return text;
    }

    public static String notEmpty(String text) throws IllegalArgumentException {
        return notEmpty(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    /**
     * 断言字符串不为空白,为空白则抛出异常
     * @param text
     * @param errorMsgTemplate
     * @param params
     * @return
     * @throws IllegalArgumentException
     */
    public static String notBlank(String text, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException(StringUtils.format(errorMsgTemplate, params));
        }
        return text;
    }


}
