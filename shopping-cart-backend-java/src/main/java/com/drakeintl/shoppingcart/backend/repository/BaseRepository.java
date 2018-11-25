package com.drakeintl.shoppingcart.backend.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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
     * persists the entities,
     * update if id exists,
     * otherwise insert and generate a new id
     *
     * @param entities
     * @return
     */
    List<T> save(Iterable<T> entities);
}
