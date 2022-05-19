/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pa.lab4.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vital
 */
public class Main {

    public static void main(String[] args) {
        var intersections = IntStream.rangeClosed(0, 9)
                    .mapToObj(i -> new Intersection("v" + i))
                    .toArray(Intersection[]::new);
        
        
        System.out.println("Streets:");
        List<Street> streets = new ArrayList<>();
        streets.add( new Street("s1",2,intersections[0],intersections[1]));
        streets.add( new Street("s2",2,intersections[0],intersections[2]));
        streets.add( new Street("s3",2,intersections[0],intersections[3]));
        streets.add( new Street("s4",2,intersections[1],intersections[2]));
        streets.add( new Street("s5",3,intersections[1],intersections[4]));
        streets.add( new Street("s6",1,intersections[2],intersections[3]));
        streets.add( new Street("s7",3,intersections[3],intersections[5]));
        streets.add( new Street("s8",2,intersections[2],intersections[5]));
        streets.add( new Street("s9",1,intersections[4],intersections[5]));
        streets.add( new Street("s10",1,intersections[2],intersections[6]));
        streets.add( new Street("s11",1,intersections[4],intersections[5]));
        streets.add( new Street("s12",1,intersections[4],intersections[7]));
        streets.add( new Street("s13",3,intersections[5],intersections[8]));
        streets.add( new Street("s14",2,intersections[4],intersections[8]));
        streets.add( new Street("s15",1,intersections[6],intersections[7]));
        streets.add( new Street("s16",1,intersections[6],intersections[8]));
        streets.add( new Street("s17",1,intersections[7],intersections[8]));
        
        List<Street> streetList = streets.stream()
                .sorted(Comparator.comparing(Street::getLength))
                .collect(Collectors
                .toCollection(LinkedList::new));
       
        for(Street street : streetList){
            System.out.println(street.toString());
        }
           
        Set<Intersection> intersectionSet = Arrays.stream(intersections)
                    .collect(
                    Collectors.toSet());
        intersectionSet.add(new Intersection("v0"));
        intersectionSet.add(new Intersection("v0"));
        
        System.out.println();
        System.out.println("Intersections:");
        for(Intersection inter : intersectionSet)
           System.out.println(inter.toString());
    }
}