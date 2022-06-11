/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.util;

import management.classes.Catalog;
import management.exceptions.InvalidCatalogException;
import management.interfaces.Command;

/**
 *
 * @author vital
 */
public class ListCommand implements Command {

    public static void list(Catalog catalog)
            throws InvalidCatalogException {
        if (catalog == null) {
            throw new InvalidCatalogException("catalog is null");
        }
        System.out.println(catalog.toString());
    }

}
