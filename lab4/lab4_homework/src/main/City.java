/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uaic.main;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vital
 */
public class City {
    private Map<Intersection, List<Street>> cityMap = new HashMap<>();

    public City() {
    }

    public void addIntersection(Intersection intersection, List<Street> street) {
        cityMap.put(intersection, street);
    }

    @Override
    public String toString() {
        return "City{" + "cityMap=" + cityMap + '}';
    }

    public List<Street> getIncidentStreets(Intersection intersection) {
        return cityMap.get(intersection);
    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }

}
