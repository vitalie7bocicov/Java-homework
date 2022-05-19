import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    private List<Identifiable> identifiableNodes = new ArrayList<>();

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
        System.out.println();
        System.out.println("All the nodes in the network sorted by name:");
        for(Node node : nodes)
            System.out.println(node.toString());
        System.out.println();
    }

    public int compareByAddress(Identifiable node1, Identifiable node2){
        return node1.getAddress().compareTo(node2.getAddress());
    }

    private void sortIdentifiableNodes(){
        for(Node node : nodes) {
            if (node instanceof Identifiable)
                identifiableNodes.add((Identifiable) node);
        }

        //sorting using an anonymous class, implementing the Comparator interface
//        Collections.sort(identifiableNodes, new Comparator<Identifiable>() {
//            @Override
//            public int compare(Identifiable o1, Identifiable o2) {
//                return o1.getAddress().compareTo(o2.getAddress());
//            }
//        });

        //sorting using lambda expressions
//        Collections.sort(identifiableNodes, (node1,node2) -> {
//            return node1.getAddress().compareTo(node2.getAddress());
//        });

        Collections.sort(identifiableNodes, this::compareByAddress);
    }

    public void printIdentifiableNodes(){
        sortIdentifiableNodes();

        System.out.println("Identifiable nodes sorted by address:");
        for(Identifiable node : identifiableNodes) {
            System.out.println(node.toString());
        }
        System.out.println();
    }

    public List<Identifiable> getIdentifiableNodes() {
        return identifiableNodes;
    }
}

