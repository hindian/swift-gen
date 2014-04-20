package hindian.core.transform;

/**
 *
 * @author shamshad
 */
public interface Function<T, S> {

    public T apply(S source);
}
