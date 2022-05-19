package Model;

/**
 *
 * @author vital
 */
public class City extends Territory {

    private Country country;
    private boolean capital;
    private double latitude;
    private double longitude;

    public City(String name) {
        super(name);
    }

    public City(String name, Territory territory, boolean capital, double latitude, double longitude) {
        super(name);
        this.country = (Country) territory;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Country getCountry() {
        return country;
    }

    public boolean isCapital() {
        return capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
