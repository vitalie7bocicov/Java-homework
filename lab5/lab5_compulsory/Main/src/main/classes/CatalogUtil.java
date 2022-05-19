/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import management.exceptions.InvalidCatalogException;

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
}
