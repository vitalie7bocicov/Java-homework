/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.util;

import java.util.Collections;
import management.classes.Catalog;
import management.interfaces.Command;

/**
 *
 * @author vital
 */
public class SortCommand implements Command{
    public static void sort(Catalog catalog){
        Collections.sort(catalog.getItems(), (item1, item2) -> {
            return item1.getId().compareTo(item2.getId());
        });
    } 
   
    
}
