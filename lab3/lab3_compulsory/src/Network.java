import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public void addNode(Node...args) {
        for(int i=0;i<args.length;i++)
            nodes.add(args[i]);
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public void sortNodes(){
        Collections.sort(nodes);
    }

    public void printNodes(){
        for(Node node : nodes)
            System.out.println(node.toString());
    }
}

