import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Node node, int value){
        cost.put(node,value);
    }

    public Integer getCost(Node node){
        return cost.get(node);
    }

    @Override
    public int compareTo(Node other) {
        if(other == null) throw new NullPointerException();
        if(other.getName() == null) throw new NullPointerException();
        return this.name.compareTo(other.name);
    }

}
