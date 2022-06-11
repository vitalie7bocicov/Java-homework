package Model;

import Model.Node;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vital
 */
public class Game implements Serializable {

    public Map<Coordinates, Node> stickMap;
    public int rows, cols;
    public boolean started;
    public Node lastMove;
    public boolean over;
    public int player;
    public int winner;

    public Game(int rows, int cols) {
        this.player = 1;
        this.started = false;
        this.over = false;
        this.rows = rows;
        this.cols = cols;
        stickMap = new HashMap<>();
        initSticks();

    }

    private int randomGen() {
        return (int) Math.floor(Math.random() * 2 + 1);
    }

    private void initSticks() {
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {

                stickMap.put(new Coordinates(i, j), new Node());
            }
        }
//vertical sticks

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 1; row++) {
                if (randomGen() > 1) {
                    Node node1 = stickMap.get(new Coordinates(row, col));
                    Node node2 = stickMap.get(new Coordinates(row + 1, col));
                    node1.addAdjNode(node2);
                    node2.addAdjNode(node1);
                }
            }
        }
//horizontal lines
        for (int col = 0; col < cols - 1; col++) {
            for (int row = 0; row < rows; row++) {
                if (randomGen() > 1) {
                    Node node1 = stickMap.get(new Coordinates(row, col));
                    Node node2 = stickMap.get(new Coordinates(row, col + 1));
                    node1.addAdjNode(node2);
                    node2.addAdjNode(node1);
                }
            }
        }

    }

    public Node getNode(int row, int col) {
        return stickMap.get(new Coordinates(row, col));
    }

    private boolean checkAdj(int row, int col) {

        if (getNode(row, col).getAdjNodes().isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isPlayable(int col, int row) {

        if (getNode(row, col).getPlayer() != -1) {
            return false;
        }

        if (!checkAdj(row, col)) {
            return false;
        }

        return true;
    }

    private boolean checkMovesLeft(int row, int col) {
        List<Node> nodes = getNode(row, col).getAdjNodes();
        for (Node node : nodes) {
            if (node.getPlayer() == -1) {
                return true;
            }
        }
        return false;
    }

    public boolean checkGameOver(int row, int col) {
        if (!checkMovesLeft(row, col)) {
            if (player == 0) {
                System.out.println("BLUE WON!");
                winner=0;
            } else {
                System.out.println("RED WON!");
                winner=1;
            }
            over = true;
            
        }
        return over;
    }
}
