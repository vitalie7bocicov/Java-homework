<html>

<body>
<a name="laborator4"></a>

<h1> Lab 4</h1>

<p>
<b></b><br>
A city hall wants to install surveillance cameras at all intersections in a city.  <br/>
To do this, it must connect all intersections with data cables, along the streets between them, such that the resulting network is connected. <br/>
We assume that the lengths (in km) of the streets between all the intersections of the city are known and the costs of installing the cables is proportional with the street lengths.<br/>
The problem is to determine how to install the data cables (on which streets) such as the total cost is minimum.

<p>Example (the dots are the intersections, the lines are the streets)
<br/>
<img src="mst-example.png"/>

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)
<ul>
<li>Create a Maven project.
<li>Create an object-oriented model of the problem. Streets have names and lengths, intersections have names. A street joins two intersections.
<!-- You should have at least the following classes: <i>Street, Intersection, City</i> and the main class. <br/> -->
<li>Create the streets and the intersections of the problem described in the example. Use <i>streams</i> in order to easily create the intersections.
<li>Create a <i>list</i> of streets, using  <i>LinkedList</i> implementation and sort it by the length, using a <i>comparator</i> expressed as a <i>lambda-expression</i> or <i>method reference</i>.
Make sure all the objects are <i>comparable</i>.
<li>Create a <i>set</i> of intersections, using a <i>HashSet</i> implementation. Verify the property that a <i>Set</i> does not contain duplicates.
<!-- <li>Iterate through both collections and print on the screen their elements, one by one.  -->
<!-- <li>Create two <i>maps</i> (having different implementations) describing the students and the school preferences and print them on the screen. -->
<!-- Use two different implementation of <i>lists</i> in order to specify the preferences. Print them on the screen. -->
<!-- Generate a large, random instance of the problem. -->
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li>Create a class that describes the city.
<li>Using Java Stream API, write a query that display all the streets that are longer than a specified value and join at least 3 streets.
<li>Use <a href="https://github.com/DiUS/java-faker">a third-party library</a> in order to generate random fake names for intersections and streets. 
<li>You may use <a href="https://jgrapht.org/javadoc/org.jgrapht.core/org/jgrapht/alg/spanning/package-summary.html">this package</a> of <a href="https://jgrapht.org/">JGraphT</a> 
in order to solve the problem (or other library).
<br/>
Note: A personal implementation of the algorithm will be will be scored extra (+1p).

<!-- and verify if the matching produced is <i>stable</i> -->
</ul>

</body>
</html>
