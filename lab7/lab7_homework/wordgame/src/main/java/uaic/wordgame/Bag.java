package uaic.wordgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author vital
 */
public class Bag {

    private final Queue<Tile> tiles = new LinkedList<>();
    private String currentPlayer;

    private void init() {
        TileCreator.create(tiles, 'a', 1, 9);
        TileCreator.create(tiles, 'b', 3, 2);
        TileCreator.create(tiles, 'c', 3, 2);
        TileCreator.create(tiles, 'd', 2, 4);
        TileCreator.create(tiles, 'e', 1, 12);
        TileCreator.create(tiles, 'f', 4, 2);
        TileCreator.create(tiles, 'g', 2, 3);
        TileCreator.create(tiles, 'h', 4, 2);
        TileCreator.create(tiles, 'i', 1, 9);
        TileCreator.create(tiles, 'j', 8, 1);
        TileCreator.create(tiles, 'k', 5, 1);
        TileCreator.create(tiles, 'l', 1, 4);
        TileCreator.create(tiles, 'm', 3, 2);
        TileCreator.create(tiles, 'n', 1, 6);
        TileCreator.create(tiles, 'o', 1, 8);
        TileCreator.create(tiles, 'p', 3, 2);
        TileCreator.create(tiles, 'q', 10, 1);
        TileCreator.create(tiles, 'r', 1, 6);
        TileCreator.create(tiles, 's', 1, 4);
        TileCreator.create(tiles, 't', 1, 6);
        TileCreator.create(tiles, 'u', 1, 4);
        TileCreator.create(tiles, 'v', 4, 2);
        TileCreator.create(tiles, 'w', 4, 2);
        TileCreator.create(tiles, 'x', 8, 1);
        TileCreator.create(tiles, 'y', 4, 2);
        TileCreator.create(tiles, 'z', 10, 1);
    }

    private void shuffle() {
        Collections.shuffle((List<Tile>) tiles);
    }

    public Bag() {
        init();
        shuffle();
    }

    public synchronized List<Tile> extractTiles(int howMany, Player player) {
        List<Tile> extracted = new ArrayList<>();
        if (tiles.isEmpty()) {
            return extracted;
        }

        if (currentPlayer == null) {
            currentPlayer = player.getName();
        }
        while (!currentPlayer.equals(player.getName())) {
            try {
                wait();
                if (currentPlayer == null) {
                    currentPlayer = player.getName();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.poll());

        }
        return extracted;

    }

    public synchronized void nextPlayer() {
        currentPlayer = null;
        notifyAll();
    }

    public void returnTiles(List<Tile> extractedTiles) {
        if (!extractedTiles.isEmpty()) {
            for (Tile tile : extractedTiles) {
                tiles.add(tile);

            }
            shuffle();
        }

    }

    public int getNrOfTilesLeft() {
        return tiles.size();
    }
}
