package hindian.core.transform;

/**
 *
 * @author shamshad
 */
public interface Function<T, S> {

    public T call(S source);
}
