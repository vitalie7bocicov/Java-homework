public class Main {

    public static void main(String[] args) {
        //using constructor to initialize Event
        Event C1 = new Event("C1",100,8,10);
        //default constructor
        Event C2 = new Event();
        //using setters
        C2.setName("C2");
        C2.setSize(100);
        C2.setStart(10);
        C2.setEnd(12);

        Event L2 = new Event("L2",30,8,10);

        Event L3 = new Event("L3",30,10,12);

        Room r1=new Room("401",30,Type.LAB);
        Room r2=new Room("403",30,Type.LAB);
        //default constructor
        Room r3=new Room();
        //using setters
        r3.setName("309");
        r3.setCapacity(100);
        r3.setType(Type.LECTURE_HALL);

        //using toString overloaded method
        System.out.println(C1.toString());
        System.out.println(C2.toString());
        System.out.println(L2.toString());
        System.out.println(L3.toString());
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());

    }
}
