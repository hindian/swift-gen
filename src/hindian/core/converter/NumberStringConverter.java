package hindian.core.converter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author shamshad
 */
public abstract class NumberStringConverter<T extends Number> extends StringConverter<T> {

    private boolean zeroOnError;

    private NumberStringConverter(boolean zeroOnError) {
        this.zeroOnError = zeroOnError;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<Byte> getByteConverter(boolean zeroOnError) {
        return zeroOnError ? BYTE_CONVERTER_ZERO : BYTE_CONVERTER;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<Integer> getIntegerConverter(boolean zeroOnError) {
        return zeroOnError ? INTEGER_CONVERTER_ZERO : INTEGER_CONVERTER;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<Short> getShortConverter(boolean zeroOnError) {
        return zeroOnError ? SHORT_CONVERTER_ZERO : SHORT_CONVERTER;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<Long> getLongConverter(boolean zeroOnError) {
        return zeroOnError ? LONG_CONVERTER_ZERO : LONG_CONVERTER;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<Float> getFloatConverter(boolean zeroOnError) {
        return zeroOnError ? FLOAT_CONVERTER_ZERO : FLOAT_CONVERTER;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<Double> getDoubleConverter(boolean zeroOnError) {
        return zeroOnError ? DOUBLE_CONVERTER_ZERO : DOUBLE_CONVERTER;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<BigInteger> getBigIntConverter(boolean zeroOnError) {
        return zeroOnError ? BIG_INTEGER_CONVERTER_ZERO : BIG_INTEGER_CONVERTER;
    }

    /**
     *
     * @param zeroOnError
     * @return
     */
    public static NumberStringConverter<BigDecimal> getBigDecimalConverter(boolean zeroOnError) {
        return zeroOnError ? BIG_DECIMAL_CONVERTER_ZERO : BIG_DECIMAL_CONVERTER;
    }
    private static final ByteConverter BYTE_CONVERTER = new ByteConverter(false);
    private static final ShortConverter SHORT_CONVERTER = new ShortConverter(false);
    private static final IntegerConverter INTEGER_CONVERTER = new IntegerConverter(false);
    private static final LongConverter LONG_CONVERTER = new LongConverter(false);
    private static final FloatConverter FLOAT_CONVERTER = new FloatConverter(false);
    private static final DoubleConverter DOUBLE_CONVERTER = new DoubleConverter(false);
    private static final BigIntegerConverter BIG_INTEGER_CONVERTER = new BigIntegerConverter(false);
    private static final BigDecimalConverter BIG_DECIMAL_CONVERTER = new BigDecimalConverter(false);
    private static final ByteConverter BYTE_CONVERTER_ZERO = new ByteConverter(true);
    private static final ShortConverter SHORT_CONVERTER_ZERO = new ShortConverter(true);
    private static final IntegerConverter INTEGER_CONVERTER_ZERO = new IntegerConverter(true);
    private static final LongConverter LONG_CONVERTER_ZERO = new LongConverter(true);
    private static final FloatConverter FLOAT_CONVERTER_ZERO = new FloatConverter(true);
    private static final DoubleConverter DOUBLE_CONVERTER_ZERO = new DoubleConverter(true);
    private static final BigIntegerConverter BIG_INTEGER_CONVERTER_ZERO = new BigIntegerConverter(true);
    private static final BigDecimalConverter BIG_DECIMAL_CONVERTER_ZERO = new BigDecimalConverter(true);

    private static class DoubleConverter extends NumberStringConverter<Double> {

        public DoubleConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public Double convertTo(String source) {
            try {
                double value = Double.parseDouble(source);
                return value;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return 0.0;
                } else {
                    throw ex;
                }
            }
        }
    }

    private static class FloatConverter extends NumberStringConverter<Float> {

        public FloatConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public Float convertTo(String source) {
            try {
                float value = Float.parseFloat(source);
                return value;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return 0.0f;
                } else {
                    throw ex;
                }
            }
        }
    }

    private static class LongConverter extends NumberStringConverter<Long> {

        public LongConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public Long convertTo(String source) {
            try {
                long value = Long.parseLong(source);
                return value;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return 0L;
                } else {
                    throw ex;
                }
            }
        }
    }

    private static class IntegerConverter extends NumberStringConverter<Integer> {

        public IntegerConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public Integer convertTo(String source) {
            try {
                int value = Integer.parseInt(source);
                return value;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return 0;
                } else {
                    throw ex;
                }
            }
        }
    }

    private static class ShortConverter extends NumberStringConverter<Short> {

        public ShortConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public Short convertTo(String source) {
            try {
                short value = Short.parseShort(source);
                return value;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return 0;
                } else {
                    throw ex;
                }
            }
        }
    }

    private static class ByteConverter extends NumberStringConverter<Byte> {

        public ByteConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public Byte convertTo(String source) {
            try {
                byte value = Byte.parseByte(source);
                return value;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return 0;
                } else {
                    throw ex;
                }
            }
        }
    }

    private static class BigIntegerConverter extends NumberStringConverter<BigInteger> {

        public BigIntegerConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public BigInteger convertTo(String source) {
            try {
                BigInteger bigInteger = new BigInteger(source);
                return bigInteger;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return BigInteger.ZERO;
                } else {
                    throw ex;
                }
            }
        }
    }

    private static class BigDecimalConverter extends NumberStringConverter<BigDecimal> {

        public BigDecimalConverter(boolean zeroOnError) {
            super(zeroOnError);
        }

        @Override
        public BigDecimal convertTo(String source) {
            try {
                BigDecimal value = new BigDecimal(source);
                return value;
            } catch (NumberFormatException ex) {
                if (super.zeroOnError) {
                    return BigDecimal.ZERO;
                } else {
                    throw ex;
                }
            }

        }
    }
}
