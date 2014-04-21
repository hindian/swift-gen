package hindian.core.util;

import hindian.core.transform.Function;
import java.util.Iterator;

/**
 *
 * @author shamshad
 */
public class ObjectValueIterator<T, V> implements Iterator<V> {

    private Iterator<T> iterator;
    private Function<V, T> transformFunction;

    public ObjectValueIterator(Iterable<T> iterableObject, Function<V, T> transformFunction) {
        this.iterator = iterableObject.iterator();
        this.transformFunction = transformFunction;
    }

    @Override
    public V next() {
        return transformFunction.apply(iterator.next());
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
