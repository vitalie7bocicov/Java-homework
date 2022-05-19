/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.classes;

import management.interfaces.Item;
import java.util.*;
import management.exceptions.InvalidCatalogException;

/**
 *
 * @author vital
 */
public class Catalog {

    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String name)
            throws InvalidCatalogException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidCatalogException("name");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)
            throws InvalidCatalogException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidCatalogException("name");
        }
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return """
               Catalog{
               name=""" + name + ", \nitems=" + items + "\n}";
    }

}
