/**
 * The Room Assignment Problem
 * We consider the problem of assigning a room to
 * each event such that the constraints are satisfied and the
 * number of used rooms is as small as possible (if possible).
 * @author Bocicov Vitalie
 */

import javax.xml.transform.SourceLocator;

public class Main {

    public static void main(String[] args) {
        try {
            //using constructor to initialize Event
            Event C1 = new Event("C1",100,8,10);
            //default constructor
            Event C2 = new Event();
            //using setters
            C2.setName("C2");
            C2.setSize(100);
            C2.setStart(10);
            C2.setEnd(12);

            Event L1 = new Event("L1",30,8,10);
            Event L2 = new Event("L2",30,8, 10);
            Event L3 = new Event("L3",30, 10,12);


            ComputerLab r1 = new ComputerLab ("401",30,"Windows");
            ComputerLab r2 = new ComputerLab();

            r2.setName("403");
            r2.setCapacity(30);
            r2.setOperatingSystem("Linux");
            //default constructor
            LectureHall r3=new LectureHall();
            //using setters
            r3.setName("405");
            r3.setCapacity(100);
            r3.setHasVideoProjector(false);
            Room r4 = new LectureHall("309", 100, true);


            Problem problem = new Problem();

            problem.addEvents(C1, C2, L1, L2);
            problem.addEvents(L3);
            problem.addRooms(r1, r2, r3, r4);
            //p.addRooms(r4); //exception thrown

            Solution solution = new Solution();
            solution.setProblem(problem);
            solution.solveProblem();
//            output:
//            C1->405
//            L1->401
//            L2->403
//            C2->405
//            L3->401
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
