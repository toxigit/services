package org.exemple.project1.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;
@MappedSuperclass
public class Person <ID extends java.io.Serializable> extends SimplePKEntity<ID>{
    @Basic
    private String forename;
    @Basic
    private String surname;

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person<?> person = (Person<?>) o;
        return forename.equals(person.forename) && surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), forename, surname);
    }

    @Override
    public String toString() {
        return "{" +
                "\"super\":"+super.toString()+
                ",\"forename\":\"" + forename + '\"' +
                ",\"surname\":\"" + surname + '\"' +
                '}';
    }
}
