# Compulsory:

I created an object-oriented model of the problem with the following classes:

1. Network (contains a List of nodes)
2. Node
3. Computer (extends Node implements Identifiable,Storage)
4. Router (extends Node implements Identifiable)
5. Switch (extends Node).

I created the following interfaces:

- Identifiable
- Storage

I created the nodes from the example:

```
locations are: v1 (Computer A) v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).
```

```Java
        Computer v1 = new Computer();
        v1.setName("Computer A");
        v1.setAddress("192.168.1.1");
        v1.setStorageCapacity(10);

        Router v2 = new Router("Router A","192.168.0.1");
        ...

```

I added the nodes created above to the network.

```Java
        Network network = new Network();
        network.addNode(v1,v2,v3,v4,v5,v6);
```

I sorted the List of nodes using the sort method from the Collections class and the compareTo method, as a callback, from the Comparable class:

```Java
-Collections.sort(nodes);
```

```Java
@Override
public int compareTo(Node other) {
if(other == null) throw new NullPointerException();
if(other.getName() == null) throw new NullPointerException();
return this.name.compareTo(other.name);
}
```

I printed the sorted nodes from the network, sorted by name:

```
Computer{name='Computer A', address='192.168.1.1', storageCapacity=10}
Computer{name='Computer B', address='192.168.2.2', storageCapacity=2}
Router{name='Router A', address='192.168.0.1'}
Router{name='Router B', address='192.168.1.2'}
Switch{name='Switch A'}
Switch{name='Switch B'}
```

---

# Homework:

I created and printed the complete network in the example, with the time costs.

```Java
        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,20);
        v3.setCost(v4,10);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);

```

output:

```
        Nodes in the network with the time costs:
        Computer A--Router A	10
        Computer A--Switch A	50
        Router A--Router B	20
        Router A--Switch A	20
        Router A--Switch B	20
        Router B--Computer B	20
        Switch A--Switch B	10
        Switch B--Computer B	10
        Switch B--Router B	30
```

I created a default method in the interface Storage, that is able to return the storage capacity in other units of storage (megabyte, kilobyte, byte):

```Java
 default long convertGBto(String unit){
        if(unit.equals("MB")){
            return this.getStorageCapacity() * 1024;
        }
        if(unit.equals("KB")){
            return this.getStorageCapacity() * 1024 * 1024;
        }
        if(unit.equals("B")){
            return this.getStorageCapacity() * 1024 * 1024 * 1024;
        }

        throw new ArithmeticException("Bad unit!");
    }
```

output:

        10 GB = 10240 MB
        10 GB = 10485760 KB
        10 GB = 10737418240 B

In the Network class, i created a method to display the nodes that are identifiable, sorted by their addresses. The sort method:

```Java
    private void sortIdentifiableNodes(){
        for(Node node : nodes) {
            if (node instanceof Identifiable)
                identifiableNodes.add((Identifiable) node);
        }

        //sorting using an anonymous class, implementing the Comparator interface (the old way)
       Collections.sort(identifiableNodes, new Comparator<Identifiable>() {
           @Override
           public int compare(Identifiable o1, Identifiable o2) {
               return o1.getAddress().compareTo(o2.getAddress());
            }
       });

        //sorting using lambda expressions
       Collections.sort(identifiableNodes, (node1,node2) -> {
           return node1.getAddress().compareTo(node2.getAddress());
        });

        Collections.sort(identifiableNodes, this::compareByAddress);
    }
```

output:

```
Router{name='Router A', address='192.168.0.1'}
Computer{name='Computer A', address='192.168.1.1', storageCapacity=10}
Router{name='Router B', address='192.168.1.2'}
Computer{name='Computer B', address='192.168.2.2', storageCapacity=2}
```

I immplemented the Floyd–Warshall algorithm to determine all the shortests times required for data packets to travel from an identifiable node to another.

I created the adjacency matrix of the network using the List of the nodes and the cost from one node to their neighbors:

```Java
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
```

Then i applied the Floyd-Warshall algorithm on the adjancency matrix of the network:

```Java
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

```

Output:

```
        Shortest time required for data packets to travel from an identifiable node to another:
        Computer A--Computer B 40
        Computer A--Router A 10
        Computer A--Router B 30
        Computer B--Router A 30
        Computer B--Router B 20
        Router A--Router B 20
```
