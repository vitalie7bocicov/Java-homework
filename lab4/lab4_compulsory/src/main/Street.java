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
public class Street {
    private String name;
    private int length;
    private Intersection intersectionUp;
    private Intersection intersectionDown;
    public Street() {
    }

    public Street(String name, int length, Intersection intersectionUp, Intersection intersectionDown) {
        this.name = name;
        this.length = length;
        this.intersectionUp = intersectionUp;
        this.intersectionDown = intersectionDown;
    }
    
       
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection getIntersectionUp() {
        return intersectionUp;
    }

    public Intersection getIntersectionDown() {
        return intersectionDown;
    }

  
    @Override
    public String toString() {
        return "Street{" + "name=" + name + ", length=" + length + ", intersectionUp=" + intersectionUp + ", intersectionDown=" + intersectionDown + '}';
    }

    
        
}
