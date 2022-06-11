/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.util;

import management.classes.Catalog;
import management.exceptions.InvalidCatalogException;
import management.exceptions.InvalidIdException;
import management.interfaces.Command;
import management.interfaces.Item;

/**
 *
 * @author vital
 */
public class FindCommand implements Command{
    public static Item findById(Catalog catalog, String id) 
            throws InvalidIdException, InvalidCatalogException{
        if(catalog==null ) 
            throw new InvalidCatalogException("catalog is null");
        if(id==null || id.trim().equals(""))
            throw new InvalidIdException(id + "is null");
        return catalog.getItems().stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}
