package uaic.wordgame;

import java.util.Queue;

/**
 *
 * @author vital
 */
public class TileCreator {

    public static void create(Queue<Tile> tiles, char letter, int points, int howMany) {
        for (int i = 0; i < howMany; i++) {
            tiles.add(new Tile(letter, points));
        }
    }
}
