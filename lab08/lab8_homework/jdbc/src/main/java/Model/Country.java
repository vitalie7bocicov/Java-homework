package Model;

/**
 *
 * @author vital
 */
public class Country extends Territory {

    private String code;
    private Continent continent;

    public Country(String name, String code, Territory territory) {
        super(name);
        this.code = code;
        this.continent = (Continent) territory;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public Continent getContinent() {
        return continent;
    }

}
