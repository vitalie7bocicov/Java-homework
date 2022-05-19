/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.classes;

import management.interfaces.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import management.exceptions.InvalidCatalogException;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author vital
 */
public class CatalogUtil {

    public static void save(Catalog catalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public static void view(Item item)
            throws IOException, NullPointerException, IllegalArgumentException, URISyntaxException{
        
        Desktop desktop = Desktop.getDesktop();
        File myItem = new File(item.getLocation());
        
        UrlValidator urlValidator = new UrlValidator();
        if(urlValidator.isValid(item.getLocation()))
            desktop.browse(new URI(item.getLocation()));
        else
            desktop.open(myItem);
    }

}
