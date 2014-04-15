package hindian.core.converter;

/**
 *
 * @author shamshad
 */
public abstract class StringConverter<T> extends javafx.util.StringConverter<T> implements Converter<String, T> {

    @Override
    public String convertFrom(T destination) {
        return destination == null ? null : destination.toString();
    }

    @Override
    public final String toString(T t) {
        return convertFrom(t);
    }

    @Override
    public final T fromString(String string) {
        return convertTo(string);
    }
}
