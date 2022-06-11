import java.util.Map;

public class Router extends Node implements Identifiable{
    private String address;

    public Router() {
    }

    public Router(String name, String address) {
        super(name);
        this.address = address;
    }

    @Override
    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + this.getName() + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
