/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package management.classes;

import freemarker.template.TemplateException;
import management.interfaces.Item;
import java.io.IOException;
import java.net.URISyntaxException;
import management.exceptions.InvalidCatalogException;
import management.exceptions.InvalidIdException;
import management.exceptions.InvalidYearException;
import management.util.AddCommand;
import management.util.FindCommand;
import management.util.InfoCommand;
import management.util.ListCommand;
import management.util.ReportCommand;
import management.util.SaveCommand;
import management.util.SortCommand;
import management.util.ViewCommand;
import org.apache.tika.exception.TikaException;

/**
 *
 * @author vital
 */
public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        try {
            app.testCreateSave();
            app.testLoadView();
        } catch (IOException e) {
            System.out.println("IO exception : " + e.getMessage());
        } catch (InvalidIdException e) {
            System.out.println("Invalid id exception: " + e.getLocalizedMessage());
        } catch (InvalidCatalogException e) {
            System.out.println("Invalid catalog exception: " + e.getLocalizedMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPoiterException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument exception: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI exception: " + e.getMessage());
        } catch (TemplateException e) {
            System.out.println("Template exception: " + e.getMessage());
        } catch (InvalidYearException e) {
            System.out.println("Invalid year exception: " + e.getMessage());
        } catch (TikaException e) {
            System.out.println("Tika exception: " + e.getMessage());
        }

    }

    private void testCreateSave() throws IOException, InvalidIdException, InvalidCatalogException, IllegalArgumentException, InvalidYearException {
        Catalog catalog = new Catalog("Advanced Programming resources");
        Item book1 = new Book("book1", "Curs practic de Java", "https://profs.info.uaic.ro/~acf/java/Cristian_Frasinaru-Curs_practic_de_Java.pdf", "2022", "C. Frăsinaru");
        Item curs1 = new Article("curs1", "Introduction", "C:\\Users\\vital\\Desktop\\facultate\\PA\\01_intro_slide_en.pdf", "2022", "C. Frăsinaru", "https://profs.info.uaic.ro/~acf/java/labs/lab_01.html", "https://github.com/vitalie7bocicov/ProgramareAvansata/tree/main/lab1");
        Item curs2 = new Article("curs2", "Objects and Classes", "C:\\Users\\vital\\Desktop\\facultate\\PA\\02_objects_classes_slide_en.pdf", "2022", "C. Frăsinaru", "https://profs.info.uaic.ro/~acf/java/labs/lab_02.html", "https://github.com/vitalie7bocicov/ProgramareAvansata/tree/main/lab2");
        Item curs3_1 = new Article("curs3_1", "Interfaces", "C:\\Users\\vital\\Desktop\\facultate\\PA\\03_1_interfaces_slide_en.pdf", "2022", "C. Frăsinaru");
        Item curs3_2 = new Article("curs3_2", "Generics", "C:\\Users\\vital\\Desktop\\facultate\\PA\\03_2_generics_slide_en.pdf", "2022", "C. Frăsinaru");
        Item curs3_3 = new Article("curs3_3", "Collections", "C:\\Users\\vital\\Desktop\\facultate\\PA\\03_3_collections_slide_en.pdf", "2022", "C. Frăsinaru", "https://profs.info.uaic.ro/~acf/java/labs/lab_03.html", "https://github.com/vitalie7bocicov/ProgramareAvansata/tree/main/lab3");
        Item curs4 = new Article("curs4", "Streams", "C:\\Users\\vital\\Desktop\\facultate\\PA\\04_streams_slide_en.pdf", "2022", "C. Frăsinaru", "https://profs.info.uaic.ro/~acf/java/labs/lab_04.html", "https://github.com/vitalie7bocicov/ProgramareAvansata/tree/main/lab4");
        Item curs5_1 = new Article("curs5_1", "Exceptions", "C:\\Users\\vital\\Desktop\\facultate\\PA\\05_exceptions_slide_en.pdf", "2022", "C. Frăsinaru");
        Item curs5_2 = new Article("curs5_2", "Input Output", "C:\\Users\\vital\\Desktop\\facultate\\PA\\06_input_output_slide_en.pdf", "2022", "C. Frăsinaru", "https://profs.info.uaic.ro/~acf/java/labs/lab_05.html", "https://github.com/vitalie7bocicov/ProgramareAvansata/tree/main/lab5/lab5_compulsory/Main/src/main");
        AddCommand.add(catalog, book1);
        AddCommand.add(catalog, curs1);
        AddCommand.add(catalog, curs2);
        AddCommand.add(catalog, curs3_1);
        AddCommand.add(catalog, curs3_2);
        AddCommand.add(catalog, curs3_3);
        AddCommand.add(catalog, curs4);
        AddCommand.add(catalog, curs5_1);
        AddCommand.add(catalog, curs5_2);

        SortCommand.sort(catalog);
        ListCommand.list(catalog);
        SaveCommand.save(catalog, "catalog1.json");
    }

    private void testLoadView() throws InvalidCatalogException, IOException, URISyntaxException, TemplateException, IllegalArgumentException, TikaException {
        Catalog catalog = CatalogUtil.load("catalog1.json");
        //ListCommand.list(catalog);
        ReportCommand.report(catalog);
        //ViewCommand.viewItem(FindCommand.findById(catalog,"book1"));
        InfoCommand.info(FindCommand.findById(catalog, "curs2"));
    }
}
