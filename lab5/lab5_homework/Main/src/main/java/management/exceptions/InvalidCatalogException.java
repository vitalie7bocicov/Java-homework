/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.exceptions;

/**
 *
 * @author vital
 */
public class InvalidCatalogException extends Exception {

    public InvalidCatalogException(Exception e) {
        super("Invalid catalog file.", e);
    }
    
    public InvalidCatalogException(String e) {
        super("Invalid catalog: " + e);
    }
}
