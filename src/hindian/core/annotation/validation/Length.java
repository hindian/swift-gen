package hindian.core.annotation.validation;

import hindian.core.annotation.Message;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author shamshad
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {

    int max() default Integer.MAX_VALUE;

    int min() default 0;

    Message message() default @Message(key = "__default", message = "");
}
