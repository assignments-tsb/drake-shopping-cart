package com.drakeintl.shoppingcart.backend.repository;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.*;

//in a real application we probably should be extending
//something the Spring Data framework provides,
//depending on the persistence technology

/**
 *
 * @param <T> entity class
 * @param <ID> id type, normally Long or String
 */
public interface BaseRepository<T,ID extends Serializable> {

    /**
     * tries to find the entity given the id
     *
     * @param id unique identifier for the entity
     * @return and optional wrapper for the entity; empty if not found
     */
    Optional<T> find(ID id);

    /**
     * searches the database using the provided ids
     *
     * @param ids
     * @return
     */
    List<T> find(Iterable<ID> ids);

    /**
     *
     * @return all the entities of type T
     */
    List<T> findAll();

    /**
     * for convenience
     *
     * @param t the first element should not be null
     * @param others optional
     * @return the list of newly persisted entities
     */
    default List<T> save(T t, T... others) {
        Preconditions.checkNotNull(t);
        return this.save(Lists.asList(t, others));
    }

    /**
     * persists the entities,
     * update if id exists,
     * otherwise insert and generate a new id
     *
     * @param entities
     * @return
     */
    List<T> save(Iterable<T> entities);
}
