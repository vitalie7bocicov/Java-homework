import java.util.Map;

public class Switch extends Node {
    public Switch() {
    }

    public Switch(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Switch{"  +
                "name='" + this.getName() +
                "'}";
    }
}
