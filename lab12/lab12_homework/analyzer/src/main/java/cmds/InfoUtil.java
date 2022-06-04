package cmds;

import annot.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author vital
 */
public class InfoUtil {

    public static void execute(Class test) {
        System.out.println(test + "{");

        for (Field m : test.getDeclaredFields()) {

            System.out.println("    " + m + ";");

        }

        for (Method m : test.getDeclaredMethods()) {

            System.out.println("    " + m + ";");

        }
        System.out.println("}");
    }
}
