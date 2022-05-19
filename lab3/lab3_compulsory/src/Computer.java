import java.util.Map;

public class Computer extends Node implements Identifiable, Storage{
    private String address;
    private int storageCapacity;

    public Computer() {
    }

    public Computer(String name, String address, int storageCapacity) {
        super(name);
        this.address = address;
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String getAddress(){
        return this.address;
    }

    @Override
    public int getStorageCapacity() {
        return this.storageCapacity;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + this.getName() + '\'' +
                ", address='" + address + '\'' +
                ", storageCapacity=" + storageCapacity +
                '}';
    }
}
