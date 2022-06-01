<html>
<body>

<h1> Lab 1</h1>
<b>[valid 2021-2022]</b>

<p>

<b>Introduction to <a href="https://docs.oracle.com/javase/tutorial/">Java Programming</a></b> <br/>

<p>
<p><b>1. Compulsory</b> (1p) <br/>
Write a Java application that implements the following operations: <br/>
<ul>
<li> Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
<li> Define an array of strings <code>languages</code>, containing <code>{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}</code>
<li> Generate a random integer <i>n</i>: <code>int n = (int) (Math.random() * 1_000_000);</code>
<li> Compute the result obtained after performing the following calculations:
<pre>
  multiply n by 3;
  add the binary number 10101 to the result;
  add the hexadecimal number FF to the result;
  multiply the result by 6;
</pre>
<li> Compute the sum of the digits in the result obtained in the previous step. This is the new result. 
While the new result has more than one digit, continue to sum the digits of the result.
<li>Display on the screen the message: <code>"Willy-nilly, this semester I will learn " + languages[result]</code>.
</ul>
  
<hr>
<p><b>2. Homework</b> (2p)
<ul>
<li> Let <i>n, p</i> be two integers and C<sub>1</sub>,...,C<sub>m</sub> a set of letters (<i>the alphabet</i>), all given as a command line arguments. Validate the arguments!
<li> Create an array of <i>n</i> strings (called <i>words</i>), each word containing exactly <i>p</i> characters from the given alphabet. <br/> 
Display on the screen the generated array.

<li> Two words are <i>neighbors</i> if they have a common letter.  <br/>
Create a boolean <i>n x n</i> matrix, representing the adjacency relation of the words. <br/>
Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen.

<li> For larger <i>n</i> display the running time of the application in nanoseconds (DO NOT display the data structure!). 
Try <i>n &gt; 30_000</i>. You might want to adjust the JVM Heap Space using the VM options <i>-Xms4G -Xmx4G</i>.
<li> Launch the application from the command line, for example: <code>java Lab1 100 7 A C G T</code>.
</ul>

<hr>
<p><b>3. Bonus</b> (2p)
<br/>
<ul>
<li> Implement an efficient algorithm that determines, if possible, a subset of distinct words W<sub>1</sub>,W<sub>2</sub>,...,W<sub>k</sub> (from the ones that you have generated)
such that <b>k &ge; 3</b> and W<sub>i</sub> and W<sub>i+1</sub> are neighbors, for all i in [1..k], where W<sub>k+1</sub>=W<sub>1</sub>.<br/>
<!-- Can you guarantee a lower limit better than 3 for k? (Adapt your algorithm accordingly)<br/> -->
Can you find the largest possible k? <br/>
</ul>

<p>
<p>
<hr>
<b>Notes</b>
<ul>
<li>Create a new project for each laboratory. In a project, create at least one package. Create classes as necessary, do not use the same class for unrelated tasks.
Each class must contain the name(s) of the author(s) as a comment. 
<li>Please consult <a href="https://docs.oracle.com/javase/8/docs/api/">the API documentation </a> to learn more information about the classes and methods used!
<li>Write code faster using <a href="https://netbeans.org/project_downloads/usersguide/shortcuts-80.pdf">keyboard shortcuts</a>.
</ul>

<p>
<b>Resources</b>
<ul>
<li> <a href="slides/lab_01.pdf">Slides</a> 
<li> Download <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html"> JDK </a>
<li> Download <a href="https://netbeans.org">Netbeans</a> or other Java IDE.
<li> <a href="http://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html"> Language Basics </a>
<li> <a href="https://docs.oracle.com/javase/tutorial/java/data/index.html"> Numbers and Strings </a>
<li> <a href="https://netbeans.org/kb/docs/java/quickstart.html"> NetBeans IDE Java Quick Start Tutorial</a>
</ul>

<p>
<b>Objectives</b>
<ul>
<li> Get used with an integrated development environment (IDE): <a href="https://netbeans.org">Netbeans</a>.
<li> Get used with the Java language syntax.
<li> Create and run a simple application.
<li> Understand the following concepts: compiler, interpreter, byte-code, Java Virtual Machine (JVM), portability.
<li> Use the <a href="http://unicode.org/">Unicode</a> alphabet and Java special characters.
<li> Work with primitive data types and strings (<a href="https://docs.oracle.com/javase/8/docs/api/java/lang/String.html">String</a>, 
<a href="https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html">StringBuilder</a>).
<li> Work with one- and multi-dimensional arrays.
<li> Parse command line arguments. 
<li> Perform conversions between strings and numbers.
<li> Split a string into tokens.
<li> Generate random numbers.
<li> Create multiple methods in the main class of the application.
</ul>

</body>
</html>
