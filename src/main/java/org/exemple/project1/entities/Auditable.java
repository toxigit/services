package org.exemple.project1.entities;

public interface Auditable {
    AuditFields getAuditFields();
    void setAuditFields(AuditFields auditFields);
}
