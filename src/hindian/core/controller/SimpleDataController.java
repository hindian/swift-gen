package hindian.core.controller;

import hindian.core.model.Persistable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        cq.where(cb.equal(root.get("id"), key));
        TypedQuery<T> query = em.createQuery(cq);
        return query.getResultList().size() > 0;
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
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> count = cb.createQuery(Long.class);
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        return 0L;
    }

    @Override
    public List<T> findAll() {
        return findRange(-1, -1);
    }

    @Override
    public List<T> findRange(int start, int length) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        TypedQuery<T> query = em.createQuery(cq);
        if (start != -1) {
            query.setFirstResult(start);
        }
        if (length != -1) {
            query.setMaxResults(length);
        }
        return query.getResultList();
    }
}
