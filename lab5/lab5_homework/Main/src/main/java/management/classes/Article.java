/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.classes;


import management.exceptions.InvalidIdException;
import management.exceptions.InvalidYearException;
import management.interfaces.Item;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author vital
 */
public class Article extends Item {

    private String lab;
    private String solution;

    public Article() {
        super("article");
    }
    
    
    public Article(String id, String title, String location, String year, String author, String lab, String solution) throws InvalidIdException, InvalidYearException{
        super(id, title, location, year, author, "article");
        
       
        this.lab = lab;
        this.solution = solution;
    }

    public Article(String id, String title, String location, String year, String author) throws InvalidIdException, InvalidYearException {
        super(id, title, location, year, author, "article");
    }

    public String getLab() {
        if (this.lab == null) {
            return "undefined";
        }
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getSolution() {
        if (this.solution == null) {
            return "undefined";
        }
        return solution;
    }

    public void setSolution(String solution){
        this.solution = solution;
    }

}
