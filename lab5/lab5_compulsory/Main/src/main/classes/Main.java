/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package management.classes;

import java.io.IOException;
import management.exceptions.InvalidCatalogException;

/**
 *
 * @author vital
 */
public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        try {
            app.testCreateSave();
            
        } catch (IOException e) {
            System.out.println("IO exception create");
        }
        try{
            app.testLoadView();
        }
        catch (IOException e) {
            System.out.println("IO exception test");
        }
           catch (InvalidCatalogException e) {
            System.out.println("CATALOG NOT FOUND");
        }
        

    }

    private void testCreateSave() throws IOException {
        Catalog catalog
                = new Catalog("MyRefs");
        var book = new Item("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "1967", "Donald E. Knuth");
        var article = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "2021", "James Gosling & others");
        catalog.add(book);
        catalog.add(article);
        System.out.println(catalog.toString());
        CatalogUtil.save(catalog, "c:/Users/vital/Desktop/catalog/catalog.json");
    }
    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("c:/Users/vital/Desktop/catalog/catalog.json");
        System.out.println(catalog.toString());
        //CatalogUtil.view(catalog.findById("article1"));
    }
}
