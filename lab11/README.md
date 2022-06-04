<html>
<body>

<a name="lab11"></a>

<h1> Lab 11</h1>

<p>
<b>REST Services</b> <br>

Continue the application created <a href="lab_10">at the previous lab</a> integrating the following functionalities:

<ul>
<li>Implement REST services needed to comunicate with the social network data (CRUD). 
</ul>

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)

<ul>
<li> Create a Spring Boot project containing the REST services for comunicating with the database.
<li> Create a REST controller containing methods for:
  <ul> 
  <li> obtaining the list of the persons, via a HTTP GET request.
  <li> adding a new person, via a HTTP POST request.
  <li> modifying the name of a person, via a HTTP PUT request.
  <li> deleting a person, via a HTTP DELETE request.
  </ul>
<li>Test your services using the browser and/or <a href="https://www.postman.com/">Postman</a>.
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>

<ul>
<li> Create REST services for inserting and reading relationships.
<li> Create a service for determining the first <i>k</i> most popular persons in the network.
<li> Create a simple client application that invokes the services above, using the support offered by Spring Boot.
<li> Document your services using <a href="https://swagger.io/">Swagger</a> or a similar tool.
<li> (+1p) Secure your services using the HTTPS protocol and <a href="https://jwt.io/">JSON Web Tokens</a>
<!-- <li> Handle the exceptions using a <i>RestControllerAdvice</i>.-->
</ul>
</body>
</html>
