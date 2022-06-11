package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import model.Country;

/**
 *
 * @author vital
 */
@Entity
@Table(name = "cities")
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
    @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name like :name"),
    @NamedQuery(name = "City.findByCapital", query = "SELECT c FROM City c WHERE c.capital = :capital"),
    @NamedQuery(name = "City.findByLatitude", query = "SELECT c FROM City c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "City.findByCountry", query = "SELECT c FROM City c WHERE c.country = :country"),
    @NamedQuery(name = "City.findByLongitude", query = "SELECT c FROM City c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "City.findByPopulation", query = "SELECT c FROM City c WHERE c.population = :population")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "capital")
    private Character capital;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "population")
    private int population;
    @JoinColumn(name = "country", referencedColumnName = "id")
    @ManyToOne
    private Country country;

    public City() {
    }

    public City(Integer id) {
        this.id = id;
    }

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(String name, Character capital, double latitude, double longitude, int population, Country country) {
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCapital() {
        return capital;
    }

    public void setCapital(Character capital) {
        this.capital = capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Main.City[ id=" + id + " ]";
    }

}
