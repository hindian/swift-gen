package hindian.core.filter;

/**
 *
 * @author shamshad
 */
public interface Filter<T> {

    public boolean accept(T object);
}
