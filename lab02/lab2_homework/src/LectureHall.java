/**
 * This is a class for Lecture Halls that extends the abstract class Room
 * @author Bocicov Vitalie
 */

public class LectureHall extends Room {
    private boolean hasVideoProjector;

    /**
     * This is the default constructor.
     */
    public LectureHall(){

    }

    /**
     * This is a constructor.
     * @param name The Lecture Hall name.
     * @param capacity The Lecture Hall capacity.
     * @param hasVideoProjector true if the Lecture Hall has a video projector, false otherwise.
     */
    public LectureHall(String name, int capacity, boolean hasVideoProjector) {
        this.setName(name);
        if(capacity<0)
            throw new ArithmeticException("Capacity can not be negative!");
        this.setCapacity(capacity);
        this.hasVideoProjector = hasVideoProjector;
    }

    /**
     * This is a getter.
     * @return true if the Lecture Hall has a video projector, false otherwise.
     */
    public boolean hasVideoProjector() {
        return hasVideoProjector;
    }

    /**
     * This is a setter.
     * @param hasVideoProjector true if the Lecture Hall has a video projector, false otherwise.
     */
    public void setHasVideoProjector(boolean hasVideoProjector) {
        this.hasVideoProjector = hasVideoProjector;
    }

    /**
     * This is an override function from the class Object.
     * @return A String with all this Lecture Hall data.
     */
    @Override
    public String toString() {
        return "LectureHall{" +
                "name='" + this.getName() + '\'' +
                ", capacity=" + this.getCapacity() +
                ", hasVideoProjector=" + this.hasVideoProjector +
                '}';
    }
}

