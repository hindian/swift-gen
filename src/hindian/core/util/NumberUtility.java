package hindian.core.util;

import hindian.core.transform.BigDecimalFunction;
import hindian.core.transform.BigIntegerFunction;
import hindian.core.transform.ByteFunction;
import hindian.core.transform.DoubleFunction;
import hindian.core.transform.FloatFunction;
import hindian.core.transform.IntegerFunction;
import hindian.core.transform.LongFunction;
import hindian.core.transform.ShortFunction;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author shamshad
 */
public class NumberUtility {

    public static int sum(byte... values) {
        int sum = 0;
        for (byte b : values) {
            sum += b;
        }
        return sum;
    }

    public static int sum(short... values) {
        int sum = 0;
        for (short s : values) {
            sum += s;
        }
        return sum;
    }

    public static long sum(long... values) {
        long sum = 0;
        for (long l : values) {
            sum += l;
        }
        return sum;
    }

    public static int sum(int... value) {
        int sum = 0;
        if (value != null) {
            for (int i : value) {
                sum += i;
            }
        }
        return sum;
    }

    public static double sum(double... value) {
        double sum = 0;
        if (value != null) {
            for (double i : value) {
                sum += i;
            }
        }
        return sum;
    }

    public static float sum(float... values) {
        float sum = 0;
        for (float f : values) {
            sum += f;
        }
        return sum;
    }

    public static BigInteger sum(BigInteger... values) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger bigInteger : values) {
            sum.add(bigInteger);
        }
        return sum;
    }

    public static BigDecimal sum(BigDecimal... values) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal bigDecimal : values) {
            sum.add(bigDecimal);
        }
        return sum;
    }

    public static <T> Integer sum(ByteFunction<T> byteFunction, T... values) {
        return sum(new IterableArray<>(values), byteFunction);
    }

    public static <T> Integer sum(ShortFunction<T> shortFunction, T... values) {
        return sum(new IterableArray<>(values), shortFunction);
    }

    public static <T> Integer sum(IntegerFunction<T> integerFunction, T... values) {
        return sum(new IterableArray<>(values), integerFunction);
    }

    public static <T> Long sum(LongFunction<T> longFunction, T... values) {
        return sum(new IterableArray<>(values), longFunction);
    }

    public static <T> Double sum(DoubleFunction<T> doubleFunction, T... values) {
        return sum(new IterableArray<>(values), doubleFunction);
    }

    public static <T> Float sum(FloatFunction<T> floatFunction, T... values) {
        return sum(new IterableArray<>(values), floatFunction);
    }

    public static <T> BigInteger sum(BigIntegerFunction<T> bigIntegerFunction, T... values) {
        return sum(new IterableArray<>(values), bigIntegerFunction);
    }

    public static <T> BigDecimal sum(BigDecimalFunction<T> bigDecimalFunction, T... values) {
        return sum(new IterableArray<>(values), bigDecimalFunction);
    }

    public static <T> Integer sum(Iterable<T> values, ByteFunction<T> byteFunction) {
        int sum = 0;
        for (T t : values) {
            sum += byteFunction.apply(t);
        }
        return sum;
    }

    public static <T> Integer sum(Iterable<T> values, ShortFunction<T> shortFunction) {
        int sum = 0;
        for (T t : values) {
            sum += shortFunction.apply(t);
        }
        return sum;
    }

    public static <T> Integer sum(Iterable<T> values, IntegerFunction<T> integerFunction) {
        int sum = 0;
        for (T t : values) {
            sum += integerFunction.apply(t);
        }
        return sum;
    }

    public static <T> Long sum(Iterable<T> values, LongFunction<T> longFunction) {
        long sum = 0;
        for (T t : values) {
            sum += longFunction.apply(t);
        }
        return sum;
    }

    public static <T> Double sum(Iterable<T> values, DoubleFunction<T> doubleFunction) {
        double sum = 0.0;
        for (T t : values) {
            sum += doubleFunction.apply(t);
        }
        return sum;
    }

    public static <T> Float sum(Iterable<T> values, FloatFunction<T> floatFunction) {
        float sum = 0.0f;
        for (T t : values) {
            sum += floatFunction.apply(t);
        }
        return sum;
    }

    public static <T> BigInteger sum(Iterable<T> values, BigIntegerFunction<T> bigIntegerFunction) {
        BigInteger sum = BigInteger.ZERO;
        for (T t : values) {
            sum.add(bigIntegerFunction.apply(t));
        }
        return sum;
    }

    public static <T> BigDecimal sum(Iterable<T> values, BigDecimalFunction<T> bigDecimalFunction) {
        BigDecimal sum = BigDecimal.ZERO;
        for (T t : values) {
            sum.add(bigDecimalFunction.apply(t));
        }
        return sum;
    }

    public static double avg(byte... value) {
        return value != null && value.length > 0 ? (double) sum(value) / value.length : 0.0;
    }

    public static double avg(short... value) {
        return value != null && value.length > 0 ? (double) sum(value) / value.length : 0.0;
    }

    public static double avg(int... value) {
        return value != null && value.length > 0 ? (double) sum(value) / value.length : 0.0;
    }

    public static double avg(long... value) {
        return value != null && value.length > 0 ? (double) sum(value) / value.length : 0.0;
    }

    public static double avg(float... value) {
        return value != null && value.length > 0 ? sum(value) / value.length : 0.0;
    }

    public static double avg(double... value) {
        return value != null && value.length > 0 ? (double) sum(value) / value.length : 0.0;
    }

    public static BigDecimal avg(BigInteger... value) {
        return value != null && value.length > 0
                ? new BigDecimal(sum(value)).divide(BigDecimal.valueOf(value.length))
                : BigDecimal.ZERO;
    }

    public static BigDecimal avg(BigDecimal... value) {
        return value != null && value.length > 0
                ? sum(value).divide(BigDecimal.valueOf(value.length))
                : BigDecimal.ZERO;
    }

    public static byte max(byte... values) {
        Precondition.checkNotEmptyOrNull(values);
        byte max = values[0];
        for (Byte b : values) {
            if (max < b) {
                max = b;
            }
        }
        return max;
    }

    public static short max(short... values) {
        Precondition.checkNotEmptyOrNull(values);
        short max = values[0];
        for (short s : values) {
            if (max < s) {
                max = s;
            }
        }
        return max;
    }

    public static int max(int... values) {
        Precondition.checkNotEmptyOrNull(values);
        int max = values[0];
        for (int integer : values) {
            if (max < integer) {
                max = integer;
            }
        }
        return max;
    }

    public static long max(long... values) {
        Precondition.checkNotEmptyOrNull(values);
        long max = values[0];
        for (long l : values) {
            if (max < l) {
                max = l;
            }
        }
        return max;
    }

    public static double max(double... values) {
        Precondition.checkNotEmptyOrNull(values);
        double max = values[0];
        for (double d : values) {
            if (max < d) {
                max = d;
            }
        }
        return max;
    }

    public static float max(float... values) {
        Precondition.checkNotEmptyOrNull(values);
        float max = values[0];
        for (float f : values) {
            if (max < f) {
                max = f;
            }
        }
        return max;
    }

    public static Byte max(Byte... values) {
        Precondition.checkNotEmptyOrNull(values);
        Byte max = values[0];
        for (Byte b : values) {
            if (max < b) {
                max = b;
            }
        }
        return max;
    }

    public static Short max(Short... values) {
        Precondition.checkNotEmptyOrNull(values);
        Short max = values[0];
        for (Short s : values) {
            if (max < s) {
                max = s;
            }
        }
        return max;
    }

    public static Integer max(Integer... values) {
        Precondition.checkNotEmptyOrNull(values);
        Integer max = values[0];
        for (Integer integer : values) {
            if (max < integer) {
                max = integer;
            }
        }
        return max;
    }

    public static Long max(Long... values) {
        Precondition.checkNotEmptyOrNull(values);
        Long max = values[0];
        for (Long l : values) {
            if (max < l) {
                max = l;
            }
        }
        return max;
    }

    public static Double max(Double... values) {
        Precondition.checkNotEmptyOrNull(values);
        Double max = values[0];
        for (Double d : values) {
            if (max < d) {
                max = d;
            }
        }
        return max;
    }

    public static Float max(Float... values) {
        Precondition.checkNotEmptyOrNull(values);
        Float max = values[0];
        for (Float f : values) {
            if (max < f) {
                max = f;
            }
        }
        return max;
    }

    public static BigInteger max(BigInteger... values) {
        Precondition.checkNotEmptyOrNull(values);
        BigInteger max = values[0];
        for (BigInteger d : values) {
            if (max.compareTo(d) < 0) {
                max = d;
            }
        }
        return max;
    }

    public static BigDecimal max(BigDecimal... values) {
        Precondition.checkNotEmptyOrNull(values);
        BigDecimal max = values[0];
        for (BigDecimal f : values) {
            if (max.compareTo(f) < 0) {
                max = f;
            }
        }
        return max;
    }

    public static <T> T max(ByteFunction<T> byteFunction, T... values) {
        Precondition.checkNotEmptyOrNull(values);
        T max = values[0];
        Byte maxValue = byteFunction.apply(max);
        for (T t : values) {
            Byte b = byteFunction.apply(t);
            if (maxValue < b) {
                maxValue = b;
                max = t;
            }
        }
        return max;
    }

    public static <T> T max(ShortFunction<T> shortFunction, T... values) {
        Precondition.checkNotEmptyOrNull(values);
        T max = values[0];
        Short maxValue = shortFunction.apply(values[0]);
        for (T t : values) {
            Short b = shortFunction.apply(t);
            if (maxValue < b) {
                maxValue = b;
                max = t;
            }
        }
        return max;
    }

    public static <T> T max(IntegerFunction<T> intFunction, T... values) {
        Precondition.checkNotEmptyOrNull(values);
        T max = values[0];
        Integer maxValue = intFunction.apply(max);
        for (T t : values) {
            Integer b = intFunction.apply(t);
            if (maxValue < b) {
                maxValue = b;
                max = t;
            }
        }
        return max;
    }

    public static <T> T max(LongFunction<T> longFunction, T... values) {
        Precondition.checkNotEmptyOrNull(values);
        T max = values[0];
        Long maxValue = longFunction.apply(max);
        for (T t : values) {
            Long b = longFunction.apply(t);
            if (maxValue < b) {
                maxValue = b;
                max = t;
            }
        }
        return max;
    }

    public static <T> T max(Iterable<T> iterable, ByteFunction<T> byteFunction) {
        Precondition.checkNotEmptyOrNull(iterable);
        Iterator<T> iterator = iterable.iterator();
        T max = iterator.next();
        Byte cacheMax = byteFunction.apply(max);
        while (iterator.hasNext()) {
            T next = iterator.next();
            Byte nextValue = byteFunction.apply(next);
            if (cacheMax < nextValue) {
                max = next;
                cacheMax = nextValue;
            }
        }
        return max;
    }

    private static class IterableArray<T> implements Iterable<T> {

        private T[] values;

        public IterableArray(T[] values) {
            Precondition.checkNotNull(values);
            this.values = values;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int current = 0;

                @Override
                public boolean hasNext() {
                    return current < values.length;
                }

                @Override
                public T next() {
                    if (current >= values.length) {
                        throw new NoSuchElementException();
                    }
                    return values[current++];
                }
            };
        }
    }
}
