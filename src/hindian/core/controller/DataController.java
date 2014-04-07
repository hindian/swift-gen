package hindian.core.controller;

import hindian.core.model.Persistable;
import java.util.List;

/**
 *
 * @author shamshad
 */
public interface DataController<T extends Persistable<PK>, PK> {

    public void save(T persistable);

    public void update(T persistable);

    public boolean exists(PK key);

    public boolean exists(T persistable);

    public T find(PK key);

    public Long count();

    public List<T> findAll();

    public List<T> findRange(int start, int length);
}
