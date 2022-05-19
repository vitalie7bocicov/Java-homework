I created an object-oriented model of the problem with the following classes:
-Network (contains a List of nodes)
-Node
-Computer (extends Node implements Identifiable,Storage)
-Router (extends Node implements Identifiable)
-Switch (extends Node).

I created the following interfaces:
-Identifiable
-Storage

I created the nodes from the example:
locations are: v1 (Computer A) v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).

I added the nodes created above to the network.

I sorted the List of nodes using the sort method from the Collections class and the compareTo method, as a callback, from the Comparable class:
-Collections.sort(nodes);
-@Override
public int compareTo(Node other) {
if(other == null) throw new NullPointerException();
if(other.getName() == null) throw new NullPointerException();
return this.name.compareTo(other.name);
}

I printed the sorted nodes from the network.
output:
Computer{name='Computer A', address='192.168.1.1', storageCapacity=100}
Computer{name='Computer B', address='192.168.2.2', storageCapacity=200}
Router{name='Router A', address='192.168.0.1'}
Router{name='Router B', address='192.168.1.2'}
Switch{name='Switch A'}
Switch{name='Switch B'}
