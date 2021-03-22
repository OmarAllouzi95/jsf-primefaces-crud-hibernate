package com.intilisic.core;

import java.util.List;
import java.util.Optional;

import com.intilisic.core.exception.BusinessException;
import com.intilisic.core.exception.DaoException;
import com.intilisic.dal.DaoFactory;
import com.intilisic.dto.Employee;

public class EmployeeBusiness {

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return DaoFactory.getDao(DaoFactory.HIBERNATE).getAll();
	}

	@SuppressWarnings("unchecked")
	public void save(Employee employee) {

		DaoFactory.getDao(DaoFactory.HIBERNATE).save(employee);
	}

	public void delete(Employee employee) throws BusinessException {
		try {
			DaoFactory.getDao(DaoFactory.HIBERNATE).delete(employee.getId());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("DATABASE_EXCEPTION");
		}
	}

	@SuppressWarnings("unchecked")
	public Optional<Employee> getById(long id) {

		return DaoFactory.getDao(DaoFactory.HIBERNATE).get(id);
	}

	@SuppressWarnings("unchecked")
	public void update(Employee employee) throws BusinessException {
		try {
			DaoFactory.getDao(DaoFactory.HIBERNATE).update(employee);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("DATABASE_EXCEPTION");
		}
	}

}
