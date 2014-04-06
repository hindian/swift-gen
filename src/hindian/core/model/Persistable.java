package hindian.core.model;

/**
 *
 * @author shamshad
 */
public interface Persistable<PK> {

    public PK getPK();

    public boolean isNew();

    public String displayString();
}
