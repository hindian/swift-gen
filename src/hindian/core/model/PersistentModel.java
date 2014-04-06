package hindian.core.model;

import java.util.Date;
import javax.persistence.Id;

/**
 *
 * @author shamshad
 */
public class PersistentModel implements Persistable<Long> {

    @Id
    private Long id;
    private Date createdDate;
    private Date modifiedDate;
    private Date deletedDate;
    private boolean deleted;

    public PersistentModel() {
        this(null);
    }

    public PersistentModel(Long id) {
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
