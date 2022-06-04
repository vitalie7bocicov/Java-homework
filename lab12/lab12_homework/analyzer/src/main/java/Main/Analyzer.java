package Main;

import cmds.InfoUtil;
import cmds.LoadUtil;
import cmds.SearchUtil;
import cmds.TestUtil;
import java.io.File;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 *
 * @author vital
 */
public class Analyzer {

    public static void main(String[] args) throws Exception {

        SearchUtil search = new SearchUtil();
        TestUtil tester = new TestUtil();
//        List<Class> classes = search.execute("Main.MyProgram");
//        List<Class> classes = search.execute("C:\\Users\\vital\\Desktop\\pa\\working\\lab7");
//        List<Class> classes = search.execute("C:\\Users\\vital\\Desktop\\pa\\working\\lab12\\myprogram");
        List<Class> classes = search.execute("C:\\Users\\vital\\Desktop\\pa\\working\\lab12\\myprogram\\src\\main\\java\\other\\MyOtherProgram.java");
        for (Class cls : classes) {
//            InfoUtil.execute(cls);
            tester.execute(cls);
        }
        tester.printStats();

    }
}
