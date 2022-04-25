package org.exemple.project1.entities;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "cities")
@AttributeOverride(name = "id",column = @Column(name = "city_id",columnDefinition = "SMALLINT UNSINGED"))
public class City extends SimplePKEntity<Integer>{
    @Basic
    private String city;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",columnDefinition = "SMALLINT UNSIGNED",referencedColumnName = "country_id",nullable = false)
    private Country country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && country.equals(city1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return "{" +
                "\"super\":"+super.toString()+
                ",\"city\":\"" + city + '\"' +
                ", \"country\":" + country +
                '}';
    }
}
