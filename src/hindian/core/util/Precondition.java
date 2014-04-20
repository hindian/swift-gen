package hindian.core.util;

import java.util.function.IntBinaryOperator;

/**
 *
 * @author shamshad
 */
public class Precondition {

    public static <T> void checkNotNull(T reference) {
        checkNotNull(reference, "Reference is null");
    }

    public static <T> void checkNotNull(T reference, String message) {
        if (reference == null) {
            throw new NullPointerException(message);
        }
    }

    public static <T> void checkNotEmptyOrNull(T[] reference) {
        checkNotEmptyOrNull(reference, "Reference is " + reference == null ? " null" : " empty");
    }

    public static <T> void checkNotEmptyOrNull(T[] reference, String message) {
        if (reference == null || reference.length == 0) {
            throw new NullOrEmptyArrayException(message);
        }
    }

    public static void checkNotEmptyOrNull(Number[] reference) {
        checkNotEmptyOrNull(reference, "Reference is " + reference == null ? " null" : " empty");
    }

    public static void checkNotEmptyOrNull(Number[] reference, String message) {
        if (reference == null) {
            throw new NullOrEmptyArrayException(message);
        } else if (reference.getClass().isArray()) {
            Object[] array = (Object[]) reference;
            if (array.length == 0) {
                throw new NullOrEmptyArrayException(message);
            }
        }
    }

    public static <T> void checkTrue(boolean expression) {
        checkTrue(expression, " Expression is evaluated to false");
    }

    public static <T> void checkTrue(boolean expression, String message) {
        if (!expression) {
            throw new ExpressionCheckException(message);
        }
    }

    public static class NullOrEmptyArrayException extends RuntimeException {

        public NullOrEmptyArrayException() {
        }

        public NullOrEmptyArrayException(String message) {
            super(message);
        }

        public NullOrEmptyArrayException(Throwable cause) {
            super(cause);
        }

        public NullOrEmptyArrayException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ExpressionCheckException extends RuntimeException {

        public ExpressionCheckException() {
        }

        public ExpressionCheckException(String message) {
            super(message);
        }

        public ExpressionCheckException(Throwable cause) {
            super(cause);
        }

        public ExpressionCheckException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
