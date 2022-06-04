package cmds;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 *
 * @author vital
 */
public class SearchUtil {

    LoadUtil loader;
    List<Class> classes;

    public SearchUtil() {
        loader = new LoadUtil();
        classes = new ArrayList<>();
    }

    public List<Class> execute(String path) throws IOException, MalformedURLException, ClassNotFoundException {
        File file = new File(path);
        if (file.isDirectory()) {
            search(file);
        } else if (!path.contains(":")) {
            loadClass(path);
        } else if (path.endsWith(".java")) {
            compile(file);
            File compiledFile = getCompiledFile(file);
            checkIfClass(compiledFile);
        }

        return classes;
    }

    public void loadClass(String className) throws MalformedURLException, ClassNotFoundException {
        classes.add(loader.execute(className));
    }

    private void compile(File file) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, file.getAbsolutePath());
        if (result == 0) {
            System.out.println("compilation done");
        }
    }

    private File getCompiledFile(File file) {
        String path = file.getAbsolutePath();
        path = path.substring(0, path.length() - 5) + ".class";
        return new File(path);
    }

    private void checkIfClass(File file) throws MalformedURLException, ClassNotFoundException {
        String className = file.getName();
        if (className.endsWith(".class")) {
            String classPath = loader.addPath(file);
            classPath = classPath.substring(0, classPath.length() - 6);
            loadClass(classPath);
            return;
        }

    }

    private void searchDir(File dir) throws MalformedURLException, ClassNotFoundException {
        if (!dir.canRead()) {
            System.out.println(dir.getAbsoluteFile() + "Permission Denied");
            return;
        }
        for (File temp : dir.listFiles()) {
            if (temp.isDirectory()) {
                search(temp);
            } else {
                checkIfClass(temp);
            }
        }
    }

    private void search(File file) {
        if (file.isDirectory()) {
            try {
                searchDir(file);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SearchUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(SearchUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                checkIfClass(file);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SearchUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(SearchUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
