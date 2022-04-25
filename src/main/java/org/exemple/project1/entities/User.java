package org.exemple.project1.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
@EntityListeners({AuditListener.class})
public class User extends PersonWithDetails<Short> implements Auditable {
    @Basic
    @Column(unique = true,nullable = false,length = 32)
    private String username;
    @Basic
    @Column(nullable = false)
    private String password;
    @Basic
    @Column(nullable = false,columnDefinition = "BIGINT default 0")
    private long roles;//this is a bitmask
    @Embedded
    private AuditFields auditFields;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRoles() {
        return roles;
    }

    public void setRoles(long roles) {
        this.roles = roles;
    }
    @Override
    public AuditFields getAuditFields() {
        return auditFields;
    }
    @Override
    public void setAuditFields(AuditFields auditFields) {
        this.auditFields = auditFields;
    }

    public LocalDateTime getCreatedAt() {
        return auditFields.getCreatedAt();
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        auditFields.setCreatedAt(createdAt);
    }

    public LocalDateTime getUpdatedAt() {
        return auditFields.getUpdatedAt();
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        auditFields.setUpdatedAt(updatedAt);
    }

    public String getCreatedBy() {
        return auditFields.getCreatedBy();
    }

    public void setCreatedBy(String createdBy) {
        auditFields.setCreatedBy(createdBy);
    }

    public String getUpdatedBy() {
        return auditFields.getUpdatedBy();
    }

    public void setUpdatedBy(String updatedBy) {
        auditFields.setUpdatedBy(updatedBy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return roles == user.roles && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(auditFields, user.auditFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, roles, auditFields);
    }

    @Override
    public String toString() {
        return "{" +
                "\"super\":"+super.toString()+
                ", \"username\":\"" + username + '\"' +
                ", \"password\":\"" + password + '\"' +
                ", \"roles\":" + roles +
                ", \"auditFields\":" + auditFields +
                '}';
    }
}
