<html>
<body>

<a name="lab8"></a>

<h1> Lab 8</h1>

<p>
<b>JDBC - World Cities</b> <br/>
Write an application that allows to <b>connect</b> to a relational database by using JDBC, <b>submit</b> SQL statements and display the results.

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)

<ul>
<li>Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
<li>Write an SQL script that will create the following tables:
<ul>
<li> <i>countries</i>: id, name, code, continent
<li> <i>continents</i>: id, name
</ul>
</pre>
<li>Update <i>pom.xml</i>, in order to add the <i>database driver</i> to the project libraries.
<li>Create a <i>singleton</i> class in order to manage a connection to the database.
<li>Create <i>DAO</i>  classes that offer methods for creating countries and continents, and finding them by their ids and names;
<li>Implement a simple test using your classes.
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>

<ul>
<li> Create the necessary table in order to store <i>cities</i> in your database. A city may contain: id, country, name, capital(0/1), latitude, longitude
<li> Create an object-oriented model of the data managed by the application.
<li> Create a <i>tool</i> to import data from a real dataset: <a href="https://www.kaggle.com/datasets/nikitagrec/world-capitals-gps">World capitals gps</a> or other.
<li> Display the <a href="https://www.geeksforgeeks.org/program-distance-two-points-earth/">distances</a> between various cities in the world.
<li> (+1p) Create a 2D map (using Swing or JavaFX) and draw on it the cities at their corresponding <a href="https://www.baeldung.com/java-convert-latitude-longitude">locations</a>.
</ul>

<li> Use a <i>connection pool</i> in order to manage database connections, such as <a href="https://www.mchange.com/projects/c3p0/">C3PO</a>, 
<a href="https://github.com/brettwooldridge/HikariCP">HikariCP</a> or <a href="http://commons.apache.org/proper/commons-dbcp/">Apache Commons DBCP</a>.
<li> Two cities are <i>sisters</i> (or <i>twins</i>) if they have a form of legal or social agreement between for the purpose of promoting cultural and commercial ties. <br/>
Using a <a href="https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadPoolExecutor.html">ThreadPoolExecutor</a> create and insert into your database a large number of fake cities (&ge;1000) 
and random sister relationships among them (the sisterhood probability should be low).
</ul>

</body>
</html>
