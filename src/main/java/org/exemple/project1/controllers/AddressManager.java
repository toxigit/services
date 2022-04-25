package org.exemple.project1.controllers;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.exemple.project1.entities.Address;

public class AddressManager implements GenericDAO<Address,Integer> {
    @Inject
    private EntityManager manager;
    @Override
    public EntityManager getEntityManager() {
        return manager;
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }
}
