# Compulsory:

I created a Maven project.

I created an object-oriented model of the problem with the following classes:
-Street
-Intersection.

I created the streets and the intersections of the problem described in the example. I used streams in order to easily create the intersections:

```Java
    var intersections = IntStream.rangeClosed(0, 9)
                    .mapToObj(i -> new Intersection("v" + i))
                    .toArray(Intersection[]::new);P
```

I created a list of streets, using LinkedList implementation and sorted it by length, using a comparator expressed a sa lambda-expression:

```Java
List<Street> streetList = streets.stream()
                .sorted(Comparator.comparing(Street::getLength))
                .collect(Collectors
                .toCollection(LinkedList::new));
```

I created a set of intersections, using a HashSet implementation. I verified the property that a Set does not contain duplicates by overriding the hashCode() and equals() function in the Interesction class.
