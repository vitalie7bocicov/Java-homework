/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.lab4.main;

import java.util.Objects;

/**
 *
 * @author vital
 */
public class Intersection {
    private String name;

    public Intersection() {
    }

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.name);
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
        final Intersection other = (Intersection) obj;
        return Objects.equals(this.name, other.name);
    }

    
    
    @Override
    public String toString() {
        return "Intersection{" + "name=" + name + '}';
    }
    
    
}
