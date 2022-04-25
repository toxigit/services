package org.exemple.project1.entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "countries")
@AttributeOverride(name = "id",column = @Column(name = "country_id",columnDefinition = "SMALLINT UNSINGED"))
public class Country extends SimplePKEntity<Integer>{
    @Basic
    private String country;
    @Basic
    private String isoCode;
    @OneToMany(mappedBy = "country")
    private final Set<City> cities=new HashSet<>();

    public String getCountry() {
        return country;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
    public void addCity(City city){
        city.setCountry(this);
        cities.add(city);
    }
    public void removeCity(City city){
        city.setCountry(null);
        cities.remove(city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Country country1 = (Country) o;
        return country.equals(country1.country) && isoCode.equals(country1.isoCode) && cities.equals(country1.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, isoCode, cities);
    }

    @Override
    public String toString() {
        return "{" +
                "\"super\":"+super.toString()+
                ",\"country\":\"" + country + '\"' +
                ", \"isoCode\":\"" + isoCode + '\"' +
                ", \"cities\":" + Arrays.deepToString(cities.toArray())  +
                '}';
    }
}
