# Homework:

I created the class City.

I used Java Stream API, write a query that display all the streets that are longer than a specified value and join at least 3 streets:

```Java
    int value = 2;
        System.out.println();
        System.out.println("Streets that are longer than " + value + " and join at least 3 streets:");
        streets.stream()
                .filter(v -> v.getLength() > value)
                .filter(v -> (city.getIncidentStreets(v.getIntersectionDown()).size()>=3) || (city.getIncidentStreets(v.getIntersectionUp()).size()>=3))
                .forEach(System.out::println);
        System.out.println();

```

I used a java-faker library in order to generate random fake names for intersections and streets.

I used the Optional class:

```Java
for(Intersection intersection : intersectionSet){
            Optional<Intersection> opt = Optional.ofNullable(intersection);

            if(opt.isPresent())
                System.out.println(opt.toString());
            else
                System.out.println("NULL intersection");
        }

```

I created the Solution class and i used PrimMinimumSpanningTree<V,​E> implementation from the package org.jgrapht.alg.spanning of JGraphT library:

```Java
public void Prim(){

        mapToGraph();
        int cost=0;
        System.out.println("\nSolution:");
        for(DefaultWeightedEdge e: new PrimMinimumSpanningTree<>(graph).getSpanningTree()) {
            System.out.println(e);
            cost+=graph.getEdgeWeight(e);
        }
        System.out.println("Cost: " + cost);
    }
```

Output:

```
Solution:
(Intersection{name=Thiel Parkway} : Intersection{name=Lizabeth Summit})
(Intersection{name=Joie Bridge} : Intersection{name=Douglas Field})
(Intersection{name=Douglas Field} : Intersection{name=Leffler Parkway})
(Intersection{name=Tromp Mountains} : Intersection{name=Dolly Pines})
(Intersection{name=Toi Port} : Intersection{name=Douglas Field})
(Intersection{name=Dolly Pines} : Intersection{name=Lizabeth Summit})
(Intersection{name=Douglas Field} : Intersection{name=Littel Run})
(Intersection{name=Dolly Pines} : Intersection{name=Toi Port})
Cost: 10

```

I packed all project classes as an executable JAR file using the command:

```
    jar cf lab4.jar *.class
```
