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
public class SaveCommand implements Command{
    public static void save(Catalog catalog, String path)
            throws IOException, InvalidCatalogException {
        if(catalog == null)
            throw new InvalidCatalogException("catalog is null");
        ObjectMapper objectMapper = new ObjectMapper();
        
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
}
