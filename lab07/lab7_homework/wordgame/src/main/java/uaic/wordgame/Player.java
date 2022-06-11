package uaic.wordgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author vital
 */
public class Player implements Runnable {

    private final String name;
    private Game game;
    private String validWord;
    private int nrOfTiles = 7;
    private List<Tile> extracted = new ArrayList<>();

    private final List<Tile> owned = new ArrayList<>();
    private int score = 0;

    public Player(String name) {
        this.name = name;

    }

    private void permute(String string, String answer) {
        if (string.length() == 0) {
            if (game.getDictionary().isWord(answer)) {
                validWord = answer;
            }
            return;
        }
        //check if current word is valid
        if (answer.length() >= 4) {
            if (game.getDictionary().isWord(answer)) {
                validWord = answer;
            }
        }
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            String ros = string.substring(0, i) + string.substring(i + 1);
            permute(ros, answer + ch);
        }
    }

    private String createWord(String word) {
        validWord = null;
        permute(word, "");
        return validWord;
    }

    private void removeTilesUpdateScore(String word) {
        int points = 0;
        int length = word.length();

        Iterator<Tile> iterator = owned.iterator();
        while (iterator.hasNext()) {
            Tile tile = iterator.next();
            //if tile is used in word
            if (word.indexOf(tile.getLetter()) != -1) {
                //get tile points
                points += tile.getPoints();
                //remove tile from owned tiles list
                iterator.remove();
                //remove letter from word
                word = word.substring(0, word.indexOf(tile.getLetter())) + word.substring(word.indexOf(tile.getLetter()) + 1);
            }
        }
        points *= length;
        score += points;
        //update player score
        game.getBoard().setScore(this.getName(), score);

    }

    private boolean submitWord() {
        String word = "";

        if (!owned.isEmpty()) {
            for (Tile tile : owned) {
                word += tile.getLetter();
            }
        }

        //first turn
        if (extracted.isEmpty()) {
            extracted = game.getBag().extractTiles(nrOfTiles, this);
            //if bag is empty the game is over
            if (extracted.isEmpty()) {
                game.isOver = true;
                return false;
            }
        }

        for (Tile tile : extracted) {
            owned.add(tile);
            word += tile.getLetter();
        }

        // create a word with all the extracted tiles;
        word = createWord(word);

        if (word != null) {
            //word created
            game.getBoard().addWord(this, word);
            nrOfTiles = word.length();
            removeTilesUpdateScore(word);
            //extract next tiles
            extracted = game.getBag().extractTiles(nrOfTiles, this);
        } else if (!game.isOver) {
            //can't create valid word
            System.out.println(getName() + ": returning tiles!");
            game.getBag().returnTiles(owned);
            owned.clear();
            nrOfTiles = 7;
            //extract next tiles
            extracted = game.getBag().extractTiles(nrOfTiles, this);
        }
        //pass turn
        game.getBag().nextPlayer();

        //thread sleept for 1.5 seconds
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        return true;
    }

    @Override
    public void run() {
        while (!game.isOver) {
            submitWord();
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

}
