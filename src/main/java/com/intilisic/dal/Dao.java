package com.intilisic.dal;

import java.util.List;
import java.util.Optional;

import com.intilisic.core.exception.DaoException;

public interface Dao<T> {

	Optional<T> get(long id);

	List<T> getAll();

	void save(T t);

	void update(T t) throws DaoException;

	void delete(long id) throws DaoException;
}
