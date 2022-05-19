/**
 * This is a class for Lecture Halls that extends the abstract class Room
 * @author Bocicov Vitalie
 */
public class ComputerLab extends Room{
    private String operatingSystem;

    /**
     * This is the default constructor.
     */
    public ComputerLab(){
    }

    /**
     * This is a constructor.
     * @param name This Computer Lab name.
     * @param capacity This Computer Lab Hall capacity.
     * @param operatingSystem The Operating System of the computers in this Computer Lab.
     */
    public ComputerLab(String name, int capacity, String operatingSystem) {
        this.setName(name);
        if(capacity<0)
            throw new ArithmeticException("Capacity can not be negative!");
        this.setCapacity(capacity);
        this.operatingSystem=operatingSystem;
    }

    /**
     * This is a getter
     * @return The Operating System of the computers in this Computer Lab.
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * This is a setter.
     * @param operatingSystem The Operating System of the computers in this Computer Lab.
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * This is an override function from the class Object.
     * @return A String with all of this Computer Lab data.
     */
    @Override
    public String toString() {
        return "ComputerLab{" +
                "name='" + this.getName() + '\'' +
                ", capacity=" + this.getCapacity() +
                ", operatingSystem=" + this.operatingSystem +
                '}';
    }

}
