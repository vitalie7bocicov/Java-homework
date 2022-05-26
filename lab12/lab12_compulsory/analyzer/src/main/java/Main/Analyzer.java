package Main;

import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author vital
 */
public class Analyzer {

    public static void main(String[] args) throws Exception {
//        URL classUrl;
//        classUrl = new URL("file:///C:/Users/vital/Desktop/pa/working/lab12/myprogram");
//        URL[] classUrls = {classUrl};
//        URLClassLoader ucl = new URLClassLoader(classUrls);
//        Class c = ucl.loadClass(args[0]); 
        int passed = 0, failed = 0;
        for (Method m
                : Class.forName(args[0]).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }

        System.out.printf(
                "Passed: %d, Failed %d%n", passed, failed);
    }
}
