package hindian.core.controller;

import hindian.core.model.Persistable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author shamshad
 */
public abstract class SimpleDataController<T extends Persistable<Long>> implements DataController<T, Long> {

    private Class<T> entityClass;
    private boolean autoCommit;
    private EntityTransaction transaction;

    public SimpleDataController(Class<T> entityClass) {
        if (entityClass == null) {
            throw new NullPointerException("Persistence class supplied is null");
        }
        this.entityClass = entityClass;
        this.autoCommit = true;
    }

    protected abstract EntityManager getEntityManager();

    @Override
    public void save(T persistable) {
        getEntityManager().persist(persistable);
    }

    @Override
    public void update(T persistable) {
        EntityManager em = getEntityManager();
        if (em.contains(persistable)) {
            em.merge(persistable);
        } else {
            em.persist(persistable);
        }
    }

    @Override
    public boolean exists(Long key) {
        return true;
    }

    @Override
    public boolean exists(T persistable) {
        return persistable == null || persistable.isNew() ? false : exists(persistable.getPK());
    }

    @Override
    public T find(Long key) {
        return getEntityManager().find(entityClass, key);
    }

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findRange(int start, int length) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
