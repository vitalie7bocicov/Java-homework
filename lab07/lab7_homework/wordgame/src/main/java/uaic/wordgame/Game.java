package uaic.wordgame;

import dictionary.MockDictionary;
import dictionary.Dictionary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vital
 */
public class Game {

    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    public TimeKeeper timer;
    public boolean isOver = false;

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
        board.setPlayer(player.getName());
    }

    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public static void main(String args[]) throws InterruptedException {

        Game game = new Game();
        game.timer = new TimeKeeper(game);
        //game.timer.setMaxTime(5);
        game.timer.start();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
        while (!game.isOver) {
            Thread.sleep(100);
        };
        game.board.showScore();
        game.timer.showTime();

    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
