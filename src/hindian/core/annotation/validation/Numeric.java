package hindian.core.annotation.validation;

import hindian.core.annotation.Message;
import hindian.core.annotation.NumericType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author shamshad
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Numeric {

    Range range() default @Range();

    NumericType type() default NumericType.INTEGER;

    Message message() default @Message(key = "__default", message = "");
}
