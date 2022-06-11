<html>
<body>

<a name="lab12"></a>
<h1> Lab 12</h1>

<p>
<b>Reflection</b> </br>
Create an application to analyze and test java classes.<br/>
The application will receive as input java classes and it will display their prototypes and perform the tests specified by the @Test annotation.

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)

<ul>
<li> The input will be a .class file, located anywhere in the file system.
<li> Load the specified class in memory, identifying dynamically its package.
<li> Using reflection, extract as many information about the class (at least its methods).
<li> Using reflection, invoke the static methods, with no arguments, annotated with @Test.
</ul>
 
<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li> The input may be a folder (containing .class files) or a .jar. You must explore it recursively.
<li> Create the complete prototype, in the same manner as <a href="https://docs.oracle.com/javase/8/docs/technotes/tools/">javap tool</a>.
<li> Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not. <br/>
If a method requires primitive (at least int) or String arguments, generate mock values for them.
<li> Print a statistics regarding the tests.
</ul>
Consider the case when the input files are .java files and compile the source code before analyzing them.

</body>
</html>
