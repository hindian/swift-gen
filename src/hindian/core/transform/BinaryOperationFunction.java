package hindian.core.transform;

/**
 *
 * @author shamshad
 */
public interface BinaryOperationFunction<R, S, T> {

    public R apply(S s, T t);
}
