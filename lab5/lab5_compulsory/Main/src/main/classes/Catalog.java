/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.classes;

import java.util.*;

/**
 *
 * @author vital
 */
public class Catalog {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", items=" + items + '}';
    }
    
}
