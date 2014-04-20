package hindian.core.util;

import hindian.core.transform.StringFunction;

/**
 *
 * @author shamshad
 */
public class StringUtility {

    /**
     * Equivalent to humanizeCamelCase
     *
     * @param value
     * @return
     */
    public static String _hc(String value) {
        return humanizeVariable(value);
    }

    /**
     *
     * @param value
     * @return
     */
    public static String _hu(String value) {
        return humanizeConstant(value);
    }

    public static String _c(String value) {
        return capitalize(value);
    }

    public static String _cf(String value) {
        return capitalizeFirst(value);
    }

    public static String _cw(String value) {
        return capitalizeWordLetter(value);
    }

    /**
     *
     * @param value
     * @return
     */
    public static String humanizeConstant(String value) {
        return value;
    }

    public static String humanizeVariable(String value) {
        return value;
    }

    public static String capitalize(String value) {
        return value;
    }

    public static String capitalizeFirst(String value) {
        return value;
    }

    public static String capitalizeWordLetter(String value) {
        return value;
    }
}
