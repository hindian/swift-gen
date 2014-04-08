package hindian.core.model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author shamshad
 */
@MappedSuperclass
public class PersistentModel extends SimplePersistentModel implements Persistable<Long> {

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;
    @Version
    private int version;
    private boolean deleted;

    public PersistentModel() {
        this(null);
    }

    public PersistentModel(Long id) {
        super(id);
        this.deleted = false;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @PrePersist
    public void initDate() {
        this.createdDate = Calendar.getInstance().getTime();
        this.modifiedDate = this.createdDate;
    }

    @PreUpdate
    public void updateDate() {
        this.modifiedDate = Calendar.getInstance().getTime();
        if (deleted) {
            this.deletedDate = this.modifiedDate;
        }
    }

    @Override
    public String displayString() {
        return "";
    }
}
