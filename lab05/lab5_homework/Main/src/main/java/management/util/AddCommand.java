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
public class AddCommand implements Command{
    public static void add(Catalog catalog, Item item) throws InvalidIdException, InvalidCatalogException {
        if(FindCommand.findById(catalog, item.getId())!=null)
              throw new InvalidIdException(item.getId() + "already exists");
        
        catalog.getItems().add(item);
        
    }
}
