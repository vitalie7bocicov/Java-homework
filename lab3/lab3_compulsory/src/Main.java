public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer();
        v1.setName("Computer A");
        v1.setAddress("192.168.1.1");
        v1.setStorageCapacity(100);

        Router v2 = new Router("Router A","192.168.0.1");

        Switch v3 = new Switch("Switch A");
        Switch v4 = new Switch("Switch B");

        Router v5 = new Router("Router B","192.168.1.2");

        Computer v6 = new Computer("Computer B", "192.168.2.2",200);

        Network network = new Network();
        network.addNode(v1,v2,v3,v4,v5,v6);
        network.sortNodes();
        network.printNodes();
    }
}
