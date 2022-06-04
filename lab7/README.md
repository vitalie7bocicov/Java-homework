<html>
<head> <title> Lab 7</title> </head>
<body>

<a name="lab7"></a>

<h1> Lab 7</h1>

<p>
<b>Concurrency</b> <br>
Write a program that simulates a <i>word game</i> between a given number of players.
<p>
At the beginning of the game there is a <i>bag</i> containing a number of <i>tiles</i>. Each tile represents a <i>letter</i> and has a number of <i>points</i>.
The application will also use a <i>dictionary</i> that contains a list of acceptable <i>words</i>.
Each player extracts 7 tiles from the bag and must create a word from the dictionary with them.
When a player creates a word, it <i>submits</i> it to the <i>board</i> and receives a number of points (the value of tile points multiplied by the length of the word).
<!-- A special bonus of 50 points is awarded if the player can use all the 7 tiles. -->
After submitting a word of length <i>k</i>, the player will immediately request other tiles <i>k</i> from the bag(if this is possible). 
If the player cannot create a word, it will discard all the tiles and extract others (and passes its turn).
The game ends when the bag becomes empty. The winner is the player with the highest score.<br/>
The players might take turns (or not...) and a time limit might be imposed (or not...).
<br/>

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)

<ul>
<li> Create an object oriented model of the problem. You may assume that there are 10 tiles for each letter in the alphabet and each letter is worth a random number of points (between 1 and 10). 
<li> Each player will have a name and they must perform in a concurrent manner, extracting repeatedly tokens from the board. 
<li> After each extraction, the player will submit to the board all the letters.
<li> <b>Simulate the game using a thread for each player</b>. <br/>
Pay attention to the <i>synchronization</i> of the threads when extracting tokens from the bag and when putting words on the board.
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li> Use the following number of tiles for each letter: <code>A-9, B-2, C-2, D-4, E-12, F-2, G-3, H-2, I-9, J-1, K-1, L-4, M-2, N-6, O-8, P-2, Q-1, R-6, S-4, T-6, U-4, V-2, W-2, X-1, Y-2, Z-1</code>
<li> Use the following points for the letters:
<pre>
(1 point)-A, E, I, O, U, L, N, S, T, R
(2 points)-D, G
(3 points)-B, C, M, P
(4 points)-F, H, V, W, Y
(5 points)-K
(8 points)- J, X
(10 points)-Q, Z
</pre>
<li> Create an implementation of a dictionary, using some collection of words. Use an appropriate collection to represent the dictionary.
This collection should be large enough; you may use <a href="http://app.aspell.net/create">aspell</a> to generate a text file containing English words, or anything similar:
<a href="https://wordnet.princeton.edu/">WordNet</a>, <a href="https://dexonline.ro/unelte">dexonline</a>, etc.
<li> Implement the scoring and determine who the winner is at the end of the game.
<li> Make sure that players wait their turns, using a <i>wait-notify</i> approach.
<li> Implement a <i>timekeeper</i> thread that runs concurrently with the player threads, as a <i>daemon</i>.
This thread will display the running time of the game and it will stop the game if it exceeds a certain time limit.
</ul>

</body>
</html>
