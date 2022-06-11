
package Model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author vital
 */
public class Node implements Serializable{

    private List<Node> adjNodes;
    private int player;

    public Node() {
         adjNodes = new ArrayList<>();
         player=-1;
    }
    
    
    
    public Boolean isAdjacent(Node node) {
           if(adjNodes.contains(node))
                return true;
         return false;
    }

    public void addAdjNode(Node node) {
        this.adjNodes.add(node);
    }

    @Override
    public String toString() {
        return "Node{" + "adjNodes=" + adjNodes + '}';
    }

    public List<Node> getAdjNodes() {
        return adjNodes;
    }


    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }


}
