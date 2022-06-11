<html>
<body>
<a name="laborator3"></a>

<h1> Lab 5</h1>
<p>
<b>Bibliography Management System</b><br>
Write an application that can manage a catalog of resources (bibliographic references), such as books, articles, etc. <br/>
These resources might be represented by files in the local file system or a Web address.
Apart from a unique identifier, a title and its location, a resource may have additional properties such as author(s), what year it was publihsed, description, etc.<br/>
You may read more about <a href="https://en.wikipedia.org/wiki/Reference_management_software">reference management software</a>, 
see a comparison of <a href="https://en.wikipedia.org/wiki/Comparison_of_reference_management_software">notable implementations</a>, such as <a href="https://en.wikipedia.org/wiki/JabRef">JabRef</a>.
<p>
Example of entries in the catalog might be:
<pre>
{"id":"knuth67", "title":"The Art of Computer Programming", "location":"d:/books/programming/tacp.ps", "year":"1967", "author":"Donald E. Knuth", "type": "book"};  
{"id":"java17", "title":"The Java Language Specification", "location":"https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "year":"2021", "author":"James Gosling & others"};  
</pre>

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)
<ul>
<li>Create an object-oriented model of the problem. You should have at least the following classes: <i>Catalog</i> and <i>Item</i>.
The items should have at least a unique identifier, a title and its location.
Consider using an interface or an abstract class in order to describe the items in a catalog. <br/>

<li> Implement the following methods representing <i>commands</i> that will manage the content of the catalog:
  <ul>
  <li> <i>add</i>: adds a new entry into the catalog;
  <li> <i>toString</i>: a textual representation of the catalog;
  <li> <i>save</i>: saves the catalog to an external file using <a href="https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/JSON">JSON</a> format; 
  you may use <a href="https://github.com/FasterXML/jackson">Jackson</a> or other library;
  <li> <i>load</i>: loads the catalog from an external file.
  </ul>
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li> Represent the commands using <b>classes instead of methods</b>. Use an interface or an abstract class in order to desribe a generic command. <br/>
Implement the commands <i>load, list, view, report</i> (create the classes <i>AddCommand</i>, <i>ListCommand</i>, etc.).
<ul>
	<li> <i>list</i>: prints the list of items on the screen;
	<li> <i>view</i>: opens an item using the native operating system application (see the <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html">Desktop</a> class);
	<li> <i>report</i>: creates (and opens) an HTML report representing the content of the catalog. <br/>
Use a <a href="http://en.wikipedia.org/wiki/Template_engine_(web)">template engine</a> such as <a href="https://freemarker.apache.org/">FreeMarker</a> or <a href="http://velocity.apache.org"> Velocity</a>,
in order to create the HTML report.
	<li>(+1p) Use <a href="https://tika.apache.org/">Apache Tika</a> in order to extract metadata from your catalog items and implement the command <i>info</i> in order to display them.
</ul>
<li> The application will signal invalid date or the commands that are not valid using <i>custom exceptions</i>.
<li> The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.
</ul>


</body>
</html>
