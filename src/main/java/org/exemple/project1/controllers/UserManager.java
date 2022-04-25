package org.exemple.project1.controllers;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.exemple.project1.entities.User;

public class UserManager implements GenericDAO<User,Short> {
    @Inject
    private EntityManager manager;
    @Override
    public EntityManager getEntityManager() {
        return manager;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
