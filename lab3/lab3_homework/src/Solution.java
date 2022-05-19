import java.util.ArrayList;
import java.util.List;

public class Solution {
    final static int INF = 99999;
    private List<Node> nodes = new ArrayList<>();
    private int time[][];
    private int nrOfNodes;

    Solution() {
    }

    Solution(Network network) {
        nodes = network.getNodes();
        nrOfNodes = nodes.size();
        time = new int[nrOfNodes][nrOfNodes];
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
        this.nrOfNodes = nodes.size();
    }


    private void initTimeMatrix(){
        int i, j, k;
        for (i = 0; i < nrOfNodes; i++)
            for (j = 0; j < nrOfNodes; j++){
                //time cost is not defined from node i to node j (==0) and i!=j (we have 2 distinct nodes)
                if(time[i][j]==0 && i!=j){
                    //cost not defined from node i to node j and from node j to node i
                    if(nodes.get(i).getCost(nodes.get(j))==null && nodes.get(j).getCost(nodes.get(i))==null)
                        time[i][j]=INF;
                    //cost is defined from node j to node i
                    else
                    if(nodes.get(j).getCost(nodes.get(i))==null){
                        time[i][j] = nodes.get(i).getCost(nodes.get(j));
                        time[j][i] = time[i][j];
                    }
                    //cost is defined from node i to node j
                    else{
                        time[i][j] = nodes.get(j).getCost(nodes.get(i));
                        time[j][i] = time[i][j];
                    }
                }
            }
    }
    //Shortest Path Algorithm from all nodes to all nodes O(n^3)
    private void floydWarshall() {
        initTimeMatrix();

        int i, j, k;

        for(k=0;k<nrOfNodes;k++){
            for(i=0;i<nrOfNodes;i++){
                for(j=0;j<nrOfNodes;j++){
                    if(time[i][k] + time[k][j] < time[i][j])
                        time[i][j] = time[i][k] + time[k][j];
                }
            }
        }
    }

    private boolean checkIdentifiable(int i, int j){
        //if nodes are not distinct
        if(nodes.get(i)==nodes.get(j))
            return false;
        if(nodes.get(i) instanceof Identifiable && nodes.get(j) instanceof Identifiable)
            return true;
        return false;
    }

    void printShortestTimeForIdentifiableNodes(){
        this.floydWarshall();
        System.out.println("Shortest time required for data packets to travel from an identifiable node to another:");
        int i,j;
        for(i=0;i<nrOfNodes-1;i++)
            for (j=i+1;j<nrOfNodes;j++){
                if(checkIdentifiable(i,j)){
                    System.out.println(nodes.get(i).getName() + "--" + nodes.get(j).getName() + " " + time[i][j]);
                }
            }
    }
}
