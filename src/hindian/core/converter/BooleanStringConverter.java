package hindian.core.converter;

/**
 *
 * @author shamshad
 */
public class BooleanStringConverter extends StringConverter<Boolean> {

    @Override
    public Boolean convertTo(String source) {
        return Boolean.parseBoolean(source);
    }
}
