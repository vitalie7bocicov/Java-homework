    /**
     * This class is for the Events
     *
     * @author Bocicov Vitalie
     */
public class Event {

    private String name;
    private int size;
    private int start;
    private int end;

    /**
     * This is the default constructor.
     */
    public Event() {
    }

    /**
     * This is constructor.
     * @param name Event name.
     * @param size Size of the event.
     * @param start Start time of the event (Ex: 10).
     * @param end End time of the event (Ex: 12).
     */
    public Event(String name, int size, int start, int end) {
        this.name = name;
        //check if size is valid
        if(size<0)
            throw new ArithmeticException("Size can not be negative!");
        this.size = size;
        //check if start time is valid
        if(start<0 || start>24)
            throw new ArithmeticException("Invalid start format!");
        this.start = start;
        //check if end time is valid
        if(end<0 || end>24)
            throw new ArithmeticException("Invalid end format!");
        this.end = end;
    }

    /**
     * This is a getter.
     * @return The name of the Event.
     */
    public String getName() {
        return name;
    }

    /**
     * This is a setter.
     * @param name The name of the Event.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a getter
     * @return The size of the Event.
     */
    public int getSize() {
        return size;
    }

    /**
     * This is a setter.
     * @param size The size of the Event.
     */
    public void setSize(int size) {
        if(size<0)
            throw new ArithmeticException("Size can not be negative!");
        this.size = size;
    }

    /**
     * This is a getter.
     * @return The start time of the Event.
     */
    public int getStart() {
        return start;
    }

    /**
     * This is a setter.
     * @param start The start time of the Event.
     */
    public void setStart(int start) {
        if(start<0 || start>24)
            throw new ArithmeticException("Invalid start format!");
        this.start = start;
    }

    /**
     * This is a getter.
     * @return The end time of the Event.
     */
    public int getEnd() {
        return end;
    }

    /**
     * This is a setter.
     * @param end The end time of the Event;
     */
    public void setEnd(int end) {
        if(end<0 || end>24)
            throw new ArithmeticException("Invalid end format!");
        this.end = end;
    }

    /**
     * This is an override function from the class Object.
     * @return A String with all this Event data.
     */
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    /**
     * This is an override function from the class Object.
     * @param o An Object type.
     * @return true if the events have the same name, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return name.equals(event.name);
    }
}
