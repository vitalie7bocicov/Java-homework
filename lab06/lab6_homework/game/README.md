# Homework:

I created the object oriented model with the following components:

-The main frame of the application.

-A configuration panel that contains:

```Java
    JLabel label; //grid size:
    JSpinner rowSpinner;
    JSpinner colSpinner;
    JButton createBtn;
    JLabel winner; //is set at the end of the game and displays the winner color

    ...

    public void setWinner() {
        if (frame.canvas.game.winner == 0) {
            winner.setForeground(Color.BLUE);
            winner.setText("BLUE WON!");
        } else {
            winner.setForeground(Color.RED);
            winner.setText("RED WON!");
        }

        frame.canvas.repaintBoard();
        frame.repaint();
    }


```

-A canvas (drawing panel) for drawing the board:

-the board is drawn using the data from the game object;

-the board is resizable because of the ComonentListener on the frame object:

```Java
this.addComponentListener(new ComponentAdapter() {
     componentResized(ComponentEvent componentEvent) {
         canvas.repaintBoard();
        repaint();
     }
});
```

-A control panel for managing the game. This panel contains (every button is implemented):

```Java
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load"); //loads the game object and repaints the board that was saved, updates the grid spinners
    JButton saveGame = new JButton("Save Game");//saves the game object with serialization
    JButton savePNG = new JButton("Save as PNG");

    ...

    exitBtn.addActionListener(this::exitGame);
    savePNG.addActionListener(this::saveAsPNG);
    saveGame.addActionListener(this::save);
    loadBtn.addActionListener(this::load);

```

---

-A game class that saves the game status (sticks, stone, current player, grid size):

```Java
 public Map<Coordinates, Node> stickMap;
    public int rows, cols;
    public boolean started;
    public Node lastMove;
    public boolean over;
    public int player;
    public int winner;

```

-A Coordinates class that is used as key pair in the HashMap of the game object

-A Node class that saves if a stone is colored, the color and the adjacency nodes as a list.

I initialized the game (class Game) by generating random sticks with a probability of 50%. I implemented the retained mode for drawing the game board.

I implemented the logic of the game. When the player execute a mouse pressed operation, a stone is drawn at the mouse location: red or blue. I implemented the validation of the move, according to the game rules in the Game class.
