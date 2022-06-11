/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package uaic.main;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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
        
        Faker faker = new Faker();
        for(Intersection intersection : intersections)
            intersection.setName(faker.address().streetName());
        
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
        streets.add( new Street("s11",1,intersections[4],intersections[7]));
        streets.add( new Street("s12",3,intersections[5],intersections[8]));
        streets.add( new Street("s13",2,intersections[4],intersections[8]));
        streets.add( new Street("s14",1,intersections[6],intersections[7]));
        streets.add( new Street("s15",1,intersections[6],intersections[8]));
        streets.add( new Street("s16",1,intersections[7],intersections[8]));
        
        
        List<Street> streetList = streets.stream()
                .sorted(Comparator.comparing(Street::getLength))
                .collect(Collectors
                .toCollection(LinkedList::new));
       
        
        Set<Intersection> intersectionSet = Arrays.stream(intersections)
                    .collect(Collectors
                    .toCollection(HashSet::new));
        
        
        
        System.out.println("\nIntersections:");
       
        for(Intersection intersection : intersectionSet){
            Optional<Intersection> opt = Optional.ofNullable(intersection);
            
            if(opt.isPresent())
                System.out.println(opt.toString());
            else
                System.out.println("NULL");
        }
           
    
    
        City city = new City();
        city.addIntersection(intersections[0],Arrays.asList(streets.get(0), streets.get(1), streets.get(2)));
        city.addIntersection(intersections[1],Arrays.asList(streets.get(0),streets.get(3),streets.get(4)));
        city.addIntersection(intersections[2],Arrays.asList(streets.get(1),streets.get(5),streets.get(7),streets.get(9)));
        city.addIntersection(intersections[3],Arrays.asList(streets.get(2), streets.get(5), streets.get(6)));
        city.addIntersection(intersections[4],Arrays.asList(streets.get(4), streets.get(8), streets.get(10), streets.get(12)));
        city.addIntersection(intersections[5],Arrays.asList(streets.get(6), streets.get(7), streets.get(8), streets.get(11)));
        city.addIntersection(intersections[6],Arrays.asList(streets.get(9), streets.get(13), streets.get(14)));
        city.addIntersection(intersections[7],Arrays.asList(streets.get(10), streets.get(13), streets.get(15)));
        city.addIntersection(intersections[8],Arrays.asList(streets.get(11), streets.get(14), streets.get(12), streets.get(15)));
        
        
        int value = 2;
        System.out.println();
        System.out.println("Streets that are longer than " + value + " and join at least 3 streets:");
        streets.stream()
                .filter(v -> v.getLength() > value)
                .filter(v -> (city.getIncidentStreets(v.getIntersectionDown()).size()>=3) || (city.getIncidentStreets(v.getIntersectionUp()).size()>=3))
                .forEach(System.out::println);
        System.out.println();
        
        
        for(Street street : streetList)
            street.setName(faker.address().streetName());
        
        System.out.println("\nIntersections:");
        for(Intersection inter : intersectionSet)
           System.out.println(inter.toString());
        
        System.out.println("\nStreets ordered by length:");
        for(Street street : streetList){
            System.out.println(street.toString());
        }
        
        
  
        Solution solution = new Solution(city);
        solution.Prim();
      
    }
}
