package hindian.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author shamshad
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Message {

    String message();

    String key();

    boolean useI18n() default true;
}
