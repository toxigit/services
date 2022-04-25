package org.exemple.project1.controllers;

import jakarta.persistence.EntityManager;
import org.exemple.project1.entities.RootEntity;

public interface GenericDAO <E extends RootEntity<ID>,ID extends java.io.Serializable> {
    EntityManager getEntityManager();
    Class<E> getEntityClass();
}
