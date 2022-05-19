/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.exceptions;

import management.interfaces.Item;

/**
 *
 * @author vital
 */
public class InvalidIdException extends RuntimeException {

    public InvalidIdException(Exception e) {
        super("Invalid id for the item.", e);
    }

    public InvalidIdException(String id) {
        super("Invalid id: " + id);
    }
}
