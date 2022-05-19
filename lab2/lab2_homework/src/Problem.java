import com.sun.jdi.request.DuplicateRequestException;

/**
 * This class is an instance of the Problem
 * @author Bocicov Vitalie
 */
public class Problem {
    private Event[] events;
    private Room[] rooms;
    private int nrOfRooms;
    private int nrOfEvents;

    /**
     * This is the default constructor
     */
    Problem() {
        nrOfEvents=0;
        nrOfRooms=0;
        events = new Event[100];
        rooms = new Room[100];
    }

    /**
     * This method adds Room to this Problem.
     * @param args An array containing one or more rooms.
     */
    public void addRooms(Room...args){
        for(int i=0;i<args.length;i++) {
            if (checkExistsRoom(args[i]) == true)
                throw new DuplicateRequestException("Room " + args[i].getName() + " already defined!");

            rooms[nrOfRooms++] = args[i];
        }
    }

    /**
     * This method adds events to this Problemw.
     * @param args An array containing one or more events.
     */
    public void addEvents(Event...args){
        for(int i=0;i<args.length;i++){
            if(checkExistsEvent(args[i]) == true)
                throw new DuplicateRequestException("Event " + args[i].getName() + " already defined!");
            events[nrOfEvents++]=args[i];
        }
    }

    /**
     * This is a getter.
     * @return An Event array with this problem events.
     */
    public Event[] getEvents() {
        return events;
    }

    /**
     * This is a getter.
     * @return A Room array with this problem rooms.
     */
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * This method checks if an event is already added to this Problem.
     * @param event Event that must be checked.
     * @return true if the event already exists, false otherwise.
     */
    private boolean checkExistsEvent(Event event){
        for(int i=0;i<nrOfEvents;i++)
            if(event.equals(events[i]))
                return true;
        return false;
    }

    /**
     * This method checks if a room is already added to this Problem.
     * @param room Room that must be checked.
     * @return true if the room already exists, false otherwise.
     */
    private boolean checkExistsRoom(Room room){
        for(int i=0;i<nrOfRooms;i++)
            if(room.equals(rooms[i]))
                return true;
        return false;
    }


    /**
     * This is a getter.
     * @return The number of the rooms added.
     */
    public int getNrOfRooms() {
        return nrOfRooms;
    }

    /**
     * This is a getter.
     * @return The number of the events added.
     */
    public int getNrOfEvents() {
        return nrOfEvents;
    }
}
