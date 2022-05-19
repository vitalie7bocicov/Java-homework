/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.classes;

import management.exceptions.InvalidIdException;
import management.exceptions.InvalidYearException;
import management.interfaces.Item;

/**
 *
 * @author vital
 */
public class Book extends Item {

    public Book() {
        super("book");
    }

    public Book(String id, String title, String location, String year, String author) throws InvalidIdException, InvalidYearException {
        super(id, title, location, year, author, "book");
    }

}
