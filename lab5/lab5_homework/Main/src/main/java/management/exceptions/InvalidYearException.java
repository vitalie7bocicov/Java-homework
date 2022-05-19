/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.exceptions;

/**
 *
 * @author vital
 */
public class InvalidYearException extends Exception {
    public InvalidYearException(){
        super("invalid year: must be positive");
    }
}
