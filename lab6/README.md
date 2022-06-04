<html>
<head> <title> Lab 6</title> </head>
<body>

<a name="lab6"></a>

<h1> Lab 6</h1>

<p>
<b><a href="https://en.wikipedia.org/wiki/Positional_game">Positional Game</a></b> <br/>
Consider a game played on a grid-shaped board. A grid is a two-dimensional structure of intersecting lines, the lines are evenly spaced, intersecting at right angles. <br/>
At the beginning of the game, there will be randomly placed small line-shaped tokens (<i>sticks</i>) that connect two adjacent intersections of the grid, along a line of the grid. <br/>
An intersection that is adjacent with at least one stick, is called a <i>node</i>.<br/>
The first player selects any node of the grid and places a circular-shaped token (<i>stone</i>) on it. 
Next, the players must alternatively choose a new unselected node that is adjacent (is connected by a stick) to the previously selected one and place a stone on it. They use stones of different colors.
The player who cannot choose another node, loses the game.
<br/>
In order to create a graphical user interface for the game, you may use either Swing or JavaFX. 
<p>
Example of a board with randomly placed sticks and stones.
<p>
<img src="game.png"/>

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)
<p>
Create the following components:
<ul>
<li> The <i>main frame</i> of the application.

<li> A <i>configuration panel</i> for introducing parameters regarding the grid size and a button for creating a new game.
The panel must be placed at the <i>top</i> part of the frame. The panel must contain at least one label and one input component.

<li> A <i>canvas (drawing panel)</i> for drawing the board. Draw the grid lines according to the values specified in the config panel.
This panel must be placed in the <i>center</i> part of the frame.

<li> A <i>control panel</i> for managing the game.
This panel will contain the buttons: <i>Load</i>, <i>Save</i>, <i>Exit</i> ,etc. and it will be placed at the <i>bottom</i> part of the frame.
<!-- <li> Use a <i>file chooser</i> in order to specify the file where the image will be saved (or load). -->
</ul>
<!-- <li> When the user presses the button <i>Draw</i> the shapes should be drawn at random locations, having random sizes and random colors. Consider using transparent colors. -->

<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li> Create the object oriented model.
<li> Initialize the game by generating random sticks and place them on the board. Implement either <b>direct</b> or <b>retained</b> mode for drawing the game board.
<li> Implement the logic of the game. When the player execute a <i>mouse pressed</i> operation, a stone must be drawn at the mouse location: red or blue depending on whose turn it is.
Validate the move, according to the game rules. Determine the winner of the game.
<li> (+0.5p) Export the current image of the game board into a PNG file.
<li> (+0.5p) Use object serialization in order to save and restore the current status of the game.
</ul>

</body>
</html>
