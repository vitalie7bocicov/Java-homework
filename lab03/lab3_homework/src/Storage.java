import java.util.IllegalFormatConversionException;

public interface Storage {
    long getStorageCapacity();

    default long convertGBto(String unit){
        if(unit.equals("MB")){
            return this.getStorageCapacity() * 1024;
        }
        if(unit.equals("KB")){
            return this.getStorageCapacity() * 1024 * 1024;
        }
        if(unit.equals("B")){
            return this.getStorageCapacity() * 1024 * 1024 * 1024;
        }

        throw new ArithmeticException("Bad unit!");
    }
}
