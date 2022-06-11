public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer();
        v1.setName("Computer A");
        v1.setAddress("192.168.1.1");
        v1.setStorageCapacity(10);

        Router v2 = new Router("Router A","192.168.0.1");

        Switch v3 = new Switch("Switch A");
        Switch v4 = new Switch("Switch B");

        Router v5 = new Router("Router B","192.168.1.2");

        Computer v6 = new Computer("Computer B", "192.168.2.2",2);

        Network network = new Network();
        network.addNode(v1,v2,v3,v4,v5,v6);
        network.sortNodes();

        network.printNodes();
        //output:
//        All the nodes in the network sorted by name:
//        Computer{name='Computer A', address='192.168.1.1', storageCapacity=10}
//        Computer{name='Computer B', address='192.168.2.2', storageCapacity=2}
//        Router{name='Router A', address='192.168.0.1'}
//        Router{name='Router B', address='192.168.1.2'}
//        Switch{name='Switch A'}
//        Switch{name='Switch B'}


        v1.setCost(v2,10);
        v1.setCost(v3,50);
        v2.setCost(v3,20);
        v2.setCost(v4,20);
        v2.setCost(v5,20);
        v3.setCost(v4,10);
        v4.setCost(v5,30);
        v4.setCost(v6,10);
        v5.setCost(v6,20);

        System.out.println("Nodes in the network with the time costs:");
        for(Node vi : network.getNodes()){
            for(Node vj : network.getNodes()){
                if(vi.getCost(vj)!=null){
                    System.out.println(vi.getName()+"--" + vj.getName() + "\t" + vi.getCost(vj));
                }
            }
        }
        System.out.println();
        //output:
//        Nodes in the network with the time costs:
//        Computer A--Router A	10
//        Computer A--Switch A	50
//        Router A--Router B	20
//        Router A--Switch A	20
//        Router A--Switch B	20
//        Router B--Computer B	20
//        Switch A--Switch B	10
//        Switch B--Computer B	10
//        Switch B--Router B	30

        System.out.println("Example of conversions using default method from the Identifiable interface:");
        System.out.println(v1.getStorageCapacity() + " GB = "  +v1.convertGBto("MB") + " MB");
        System.out.println(v1.getStorageCapacity() + " GB = "  +v1.convertGBto("KB") + " KB");
        System.out.println(v1.getStorageCapacity() + " GB = "  +v1.convertGBto("B") + " B");
        System.out.println();
        //output:
//        10 GB = 10240 MB
//        10 GB = 10485760 KB
//        10 GB = 10737418240 B

        network.printIdentifiableNodes();
        //output:
//        Router{name='Router A', address='192.168.0.1'}
//        Computer{name='Computer A', address='192.168.1.1', storageCapacity=10}
//        Router{name='Router B', address='192.168.1.2'}
//        Computer{name='Computer B', address='192.168.2.2', storageCapacity=2}

        Solution solution = new Solution(network);

        solution.printShortestTimeForIdentifiableNodes();
        //output:
//        Shortest time required for data packets to travel from an identifiable node to another:
//        Computer A--Computer B 40
//        Computer A--Router A 10
//        Computer A--Router B 30
//        Computer B--Router A 30
//        Computer B--Router B 20
//        Router A--Router B 20
    }
}
