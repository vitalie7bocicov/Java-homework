/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management.interfaces;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Objects;
import management.exceptions.InvalidIdException;
import management.exceptions.InvalidYearException;

/**
 *
 * @author vital
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")

public abstract class Item {

    private String id;
    private String title;
    private String location;
    private String year;
    private String author;
    private String type;

    public Item() {
    }

    public Item(String type) {
        this.type = type;
    }

    public Item(String id, String title, String location, String year, String author, String type) throws InvalidIdException, InvalidYearException {
        if (id == null || id.trim().equals("")) {
            throw new InvalidIdException(id);
        }
        this.id = id;
        this.title = title;
        this.location = location;
        if(year!=null && Integer.parseInt(year)<0)
            throw new InvalidYearException();
        this.year = year;
        this.author = author;
        this.type = type;
    }

    public String getType() {
        if (type == null) {
            return "undefined";
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().equals("")) {
            throw new InvalidIdException(id);
        }
        this.id = id;
    }

    public String getTitle() {
        if (this.title == null) {
            return "undefined";
        }
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getLocation() {
        if (this.location == null) {
            return "undefined";
        }
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getYear() {
        if (this.year == null) {
            return "undefined";
        }
        return year;
    }

    public void setYear(String year) throws InvalidYearException {
        if(year!=null && Integer.parseInt(year)<0)
            throw new InvalidYearException();
        this.year = year;
    }

    public String getAuthor() {
        if (this.author == null) {
            return "undefined";
        }
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return """
               
               Item{\tid=""" + id + "\n\ttitle=" + title + "\n\tlocation=" + location + "\n\tyear=" + year + "\n\tauthor=" + author + "\n}";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        return Objects.equals(this.id, other.id);
    }

}
