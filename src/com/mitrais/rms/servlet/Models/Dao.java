package com.mitrais.rms.servlet.Models;

import java.util.List;

public interface Dao<T, o> {
	/**
     * Find single record by id.
     * @param studentId id
     * @return record wrapped by {@link Optional}
     */
    List<T> findAll();
    /**
     * Persist record to database
     * @param o record
     * @return true if operation success
     */
    boolean save(T o);
    /**
     * Persist existing record to database
     * @param o record
     * @return true if operation success
     */
    boolean update(T o);
    /**
     * Remove existing record from database
     * @param o record
     * @return true if operation success
     */
    boolean delete(T o);
}
