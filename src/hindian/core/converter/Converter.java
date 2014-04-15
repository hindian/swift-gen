package hindian.core.converter;

/**
 *
 * @author shamshad
 */
public interface Converter<S, D> {

    D convertTo(S source);

    S convertFrom(D destination);
}
