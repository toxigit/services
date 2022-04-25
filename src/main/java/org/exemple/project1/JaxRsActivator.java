package org.exemple.project1;

import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/rest-api")
public class JaxRsActivator extends Application {
    public static final class CDIConfigurator{
        @Produces
        @PersistenceContext(unitName = "default")
        private EntityManager entityManager;
    }

}
