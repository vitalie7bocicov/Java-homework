<html>

<body>

<h1> Lab 2</h1>

<b>The Room Assignment Problem</b> <br/>

<p>
An instance of the Room Assignment Problem consists of <i>events</i> and <i>rooms</i>. Events may be courses, labs, seminars, etc. Rooms may be lecture halls, computer labs, etc.
<ul>
  <li> Each event has a name, a number of participants (its size), a start time and an end time.
  <li> Each room has a name, a type and a capacity.
</ul>
<p>
We consider the problem of assigning a room to each event such that the constraints are satisfied and the number of used rooms is as small as possible (if possible).

<p>Consider the following example. 
<br/>
<pre>
Events: C1(size=100, start=8, end=10), C2(size=100, start=10, end=12), L1(size=30, start=8, end=10), L2(size=30, start=8, end=10), L3(size=30, start=10, end=12), 
Rooms: 401(cap=30, lab), 403(cap=30, lab), 405(cap=30, lab), 309(cap=100, lecture hall)
</pre>

A solution may be something like that:

<pre>
C1 -> 309
C2 -> 309
L1 -> 401
L2 -> 403
L3 -> 401
</pre>

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)
<ul>
<li>Create an object-oriented model of the problem. You should have (at least) the following classes: <i>Event, Room</i>. <br/>
The start and end time will be integers. The rooms will also have the property <i>type</i>. The available types will be implemented as an <i>enum </i>.

<li> Each class should have appropriate constructors, getters and setters. <br/>Use the <a href="https://netbeans.org/features/java/editor.html"> IDE features</a> for code generation,
such as <a href="https://blogs.oracle.com/roumen/netbeans-quick-tip-2-generating-getters-and-setters">generating getters and setters</a>.

<li> The <i>toString</i> method form the <i>Object</i> class must be properly overridden for all the classes. <br/>
Use the <a href="https://netbeans.org/features/java/editor.html"> IDE features</a> for code generation, for example (in NetBeans)  press <i>Alt+Ins</i> or invoke the context menu, 
select "Insert Code" and then "toString()" (or simply start typing "toString" and then press <i>Ctrl+Space</i>).

<li>Create and print on the screen the objects in the example.
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li>Create a class that describes an instance of the <i>problem</i>.
<li> Override the <i>equals</i> method form the <i>Object</i> class for the <i>Event, Room</i> classes.
The problem should not allow adding the same event or room twice.

<li>Instead of using an <i>enum</i>, create dedicated classes for lecture halls and computer labs. <i>Room</i> will become <i>abstract</i>.
The course room may have an additional property indicating if there is a video projector, and the lab room may indicate the operating system of its computers.
<!-- <li>Implement the method <i>getSources</i> in the <i>Problem</i> class, returning an array of all the sources. -->
<li>Create a class to describe the <i>solution</i>.

<li> Implement a simple algorithm for creating a feasible solution to the problem, "trying" to minimize the number of used rooms.

<li>Write <a href="http://www.oracle.com/technetwork/java/javase/tech/index-137868.html">doc comments</a> in your source code 
and generate the class documentation using <a href="https://docs.oracle.com/javase/9/javadoc/toc.htm">javadoc</a>.
</ul>

# <<<<<<< HEAD

<hr>

> > > > > > > 3344bf71c544f0d02876bdd4f88f6a965c6b37c9

</body>
</html>
