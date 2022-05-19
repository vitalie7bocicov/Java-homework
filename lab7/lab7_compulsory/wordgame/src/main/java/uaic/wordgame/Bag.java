package uaic.wordgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author vital
 */
public class Bag {

    private final Queue<Tile> tiles = new LinkedList<>();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            for (int i = 0; i < 10; i++) {
                tiles.add(new Tile(c, (int) Math.floor(Math.random() * 10 + 1)));
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.poll());

        }
        return extracted;
    }
}
