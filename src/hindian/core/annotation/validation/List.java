package hindian.core.annotation.validation;

import hindian.core.annotation.Message;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Comparator;

/**
 *
 * @author shamshad
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface List {

    String[] value();

    Message message() default @Message(key = "__default", message = "");
}
