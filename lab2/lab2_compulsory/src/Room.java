public class Room {
    private String name;
    private Type type;
    private int capacity;

    public Room() {
    }

    public Room(String name, int capacity,Type type) {
        this.name = name;
        this.capacity = capacity;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                '}';
    }
}
