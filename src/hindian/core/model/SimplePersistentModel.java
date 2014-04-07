package hindian.core.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author shamshad
 */
@MappedSuperclass
public class SimplePersistentModel implements Persistable<Long> {

    @Id
    private Long id;

    public SimplePersistentModel() {
        this(null);
    }

    public SimplePersistentModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getPK() {
        return getId();
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    @Override
    public String displayString() {
        return "";
    }
}
