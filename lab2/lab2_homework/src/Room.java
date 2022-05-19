/**
 * This is an abstract class for the Rooms
 *
 * @author Bocicov Vitalie
 */
public abstract class Room {
    private String name;
    private int capacity;

    /**
     * This is the default constructor
     */
    public Room() {
    }

    /**
     * This is a getter.
     * @return The Room name.
     */
    public String getName() {
        return name;
    }

    /**
     * This is a setter.
     * @param name The name of the Room.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a getter.
     * @return The Room capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This is a setter.
     * @param capacity The room capacity.
     */
    public void setCapacity(int capacity) {
        if(capacity<0)
            throw new ArithmeticException("Capacity can not be negative!");
        this.capacity = capacity;
    }

    /**
     * This is an override function from the class Object.
     * @param o An Object type.
     * @return true if the rooms have the same name, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return name.equals(room.name);
    }

}
