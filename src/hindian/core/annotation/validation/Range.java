package hindian.core.annotation.validation;

import hindian.core.annotation.Message;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author shamshad
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {

    double max() default Double.MAX_VALUE;

    double min() default Double.MIN_VALUE;

    Message message() default @Message(key = "__default", message = "");
}
