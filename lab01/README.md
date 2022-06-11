<html>
<body>

<h1> Lab 1</h1>
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

</body>
</html>
