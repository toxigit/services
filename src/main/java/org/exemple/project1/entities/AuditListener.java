package org.exemple.project1.entities;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.exemple.project1.util.IdentityUtility;

import java.time.ZonedDateTime;

public class AuditListener {
    @PrePersist
    public void handleCreate(Object auditable) {
        if (auditable instanceof Auditable) {
            Auditable casted=(Auditable)auditable;
            AuditFields af = casted.getAuditFields();
            if (af == null) {
                af = new AuditFields();
                casted.setAuditFields(af);
            }
            af.setCreatedAt(ZonedDateTime.now().toLocalDateTime());
            af.setCreatedBy(IdentityUtility.whoAmI());
        }
    }
    @PreUpdate
    public void handleUpdate(Object auditable) {
        if (auditable instanceof Auditable) {
            Auditable casted=(Auditable)auditable;
            AuditFields af = casted.getAuditFields();
            af.setUpdatedAt(ZonedDateTime.now().toLocalDateTime());
            af.setUpdatedBy(IdentityUtility.whoAmI());

        }
    }
}
