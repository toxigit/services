package org.exemple.project1.entities;

import jakarta.persistence.*;

import java.util.Objects;

@MappedSuperclass
@Access(AccessType.FIELD)
public class ManualPKEntity <ID extends java.io.Serializable>implements RootEntity<ID>{
    @Id
    private ID id;
    @Version
    private Long version;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id=id;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(Long version) {
        this.version=version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualPKEntity<?> that = (ManualPKEntity<?>) o;
        return id.equals(that.id) && version.equals(that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + (id instanceof Number? id:"\""+id.toString()+"\"") +
                ", \"version\":" + version +
                '}';
    }
}
