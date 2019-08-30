import java.math.BigDecimal;

/**
 * 数字工具类
 *
 * @Auther: zhouwenbin
 * @Date: 2019/8/30 17:01
 */
public class NumberUtils {

    /**
     * 默认除法精度
     */
    private static final int DEFAUT_DIV_SCALE = 10;

    public static double add(float a, float b) {
        return add(Float.toString(a), Float.toString(b)).doubleValue();
    }

    public static double add(float a, double b) {
        return add(Float.toString(a), Double.toString(b)).doubleValue();
    }

    public static double add(double a, float b) {
        return add(Double.toString(a), Float.toString(b)).doubleValue();
    }

    public static double add(double a, double b) {
        return add(Double.toString(a), Double.toString(b)).doubleValue();
    }

    public static double add(Double a, Double b) {
        return add((Number) a, (Number) b).doubleValue();
    }

    public static BigDecimal add(Number a, Number b) {
        return add(new Number[]{a, b});
    }

    /**
     * 保证精度的加法运算
     *
     * @param values
     * @return
     */
    public static BigDecimal add(String... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }
        String value = values[0];
        BigDecimal result = new BigDecimal(value == null ? "0" : value);
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (value != null) {
                result = result.add(new BigDecimal(value));
            }
        }
        return result;
    }

    public static BigDecimal add(Number... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        Number value = values[0];
        BigDecimal result = new BigDecimal(null == value ? "0" : value.toString());
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.add(new BigDecimal(value.toString()));
            }
        }
        return result;
    }

    public static BigDecimal add(BigDecimal... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        BigDecimal value = values[0];
        BigDecimal result = null == value ? BigDecimal.ZERO : value;
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.add(value);
            }
        }
        return result;
    }


}
