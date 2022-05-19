package uaic.wordgame;

import java.util.List;

/**
 *
 * @author vital
 */
public class Player implements Runnable {

    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord() {
        String word = "";
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        for(Tile tile: extracted)
            word+=tile.getLetter();
       // create a word with all the extracted tiles;
        game.getBoard().addWord(this, word);
        
       // make the player sleep 50ms;
        return true;
    }
    
    @Override
    public void run() {
        while(true)
            submitWord();
    }

   
    public void setGame(Game game) {
        this.game = game;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public boolean isRunning() {
        return running;
    }
    
    

}
