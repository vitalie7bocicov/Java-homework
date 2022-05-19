/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import management.classes.Catalog;
import management.exceptions.InvalidCatalogException;
import management.interfaces.Command;

/**
 *
 * @author vital
 */
public class LoadCommand implements Command{
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        if(catalog == null)
            throw new InvalidCatalogException("catalog is null");
        return catalog;
    }
}
