package org.exemple.project1.controllers;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.exemple.project1.entities.Country;

public class CountryManager implements GenericDAO<Country,Integer> {
    @Inject
    private EntityManager manager;
    @Override
    public EntityManager getEntityManager() {
        return manager;
    }

    @Override
    public Class<Country> getEntityClass() {
        return Country.class;
    }
}
