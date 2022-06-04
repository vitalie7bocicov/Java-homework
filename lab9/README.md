<html>
<head> <title> Lab 09</title> </head>
<body>

<a name="lab09"></a>

<h1> Lab 9</h1>

<p>
<b>Persistence</b> </br>
Continue the application from <a href="lab_08.html">lab 8</a>, creating an object-oriented model and using JPA (Java Persistence API) in order to communicate with the relational database.

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)

<ul>
<li> Create a <i>persistence unit</i> (use EclipseLink or Hibernate or other JPA implementation). <br/>
Verify the presence of the <i>persistence.xml</i> file in your project.
Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).

<li> Define the entity classes for your model (at least one) and put them in a dedicated package. 
You may use the IDE support in order to generate entity classes from database tables. 
<!-- Inspect these classes and modify them if necessary. -->

<li> Create a <i>singleton</i> responsible with the management of an <i>EntityManagerFactory</i> object.

<li> Define <i>repository</i> clases for your entities (at least one). They must contain the following methods:
<ul>
 <li><i>create</i> - receives an entity and saves it into the database;
 <li><i>findById</i> - returns an entity based on its primary key;
 <li><i>findByName</i> - returns a list of entities that match a given name pattern. Use a <i>named query</i> in order to implement this method.
</ul>
<li> Test your application.
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li> Create all entity classes and repositories. Implement properly the <i>one-to-many</i> relationships.
<li> Create a generic <i>AbstractRepository</i> using <i>generics</i> in order to simplify the creation of the <i>repository</i> classes. 
You may take a look at the <a href="https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a> interface from Spring Framework.
<li> Insert, using JPA, a large number of cities in the database and log the execution time of your JPQL queries.

</ul>

</body>
</html>
