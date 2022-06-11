/**
 * This is the Solution class
 * @author Bocicov Vitalie
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private Problem problem;
    private Event[] events;
    private Room[] rooms;
    private boolean [] eventHasRoom;

    /**
     * This is the default constructor.
     */
    public Solution(){
    }

    /**
     * This is a constructor.
     */
    public Solution(Problem problem) {
        this.problem = problem;
        events = problem.getEvents();
        rooms = problem.getRooms();
        eventHasRoom = new boolean[problem.getNrOfEvents()];
    }

    /**
     * This is a getter.
     * @return this Problem instance.
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * This is a setter
     */
    public void setProblem(Problem problem) {
        this.problem = problem;
        events = problem.getEvents();
        rooms = problem.getRooms();
        eventHasRoom = new boolean[problem.getNrOfEvents()];
    }

    /**
     * This method checks if two events have a schedule overlap.
     * @param event1 The first event.
     * @param event2 The second event.
     * @return true if the events overlap, false otherwise.
     */
    public boolean checkOverlap(Event event1, Event event2){
        if(event1.getStart()==event2.getStart() || event2.getEnd()==event1.getEnd())
            return true;
        return false;
    }

    /**
     * This method allocates unique rooms for the events.
     * @param eventList events that have a schedule overlap.
     */
    public void allocRoom(List<Event> eventList){

        boolean roomTaken[] = new boolean[problem.getNrOfRooms()];

        for(Event event : eventList){
            for(int i=0;i< problem.getNrOfRooms();i++){
                if(rooms[i].getCapacity()==event.getSize() && !roomTaken[i]){
                    System.out.println(event.getName() + "->" + rooms[i].getName());
                    roomTaken[i]=true;
                    break;
               }
           }
        }
    }

    /**
     * This method solves the problem.
     */
    public void solveProblem() {
        for (int i = 0; i < problem.getNrOfEvents(); i++) {
            if (!eventHasRoom[i]) {
                List<Event> overlapEventList = new ArrayList<Event>();
                overlapEventList.add(events[i]);
                eventHasRoom[i] = true;
                //search for events that have a schedule overlap and add them to the overlapEventList
                for (int j = i + 1; j < problem.getNrOfEvents(); j++) {
                    if (checkOverlap(events[i], events[j]) == true) {
                        eventHasRoom[j]=true;
                        overlapEventList.add(events[j]);
                    }
                }
                allocRoom(overlapEventList);
            }
        }
    }
}


