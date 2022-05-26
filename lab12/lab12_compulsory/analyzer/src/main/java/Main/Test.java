package Main;

/**
 *
 * @author vital
 */
import java.lang.annotation.*;

/**
 * We are going to use this annotation to mark methods. The marked methods will
 * be subject to testing. It will only work for static methods with no
 * parameters...
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
