package com.intilisic.core;

import java.util.List;
import java.util.Optional;

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

	public void delete(Employee employee) {
		DaoFactory.getDao(DaoFactory.HIBERNATE).delete(employee.getId());
	}

	@SuppressWarnings("unchecked")
	public Optional<Employee> getById(long id) {

		return DaoFactory.getDao(DaoFactory.HIBERNATE).get(id);
	}

	@SuppressWarnings("unchecked")
	public void update(Employee employee) {
		DaoFactory.getDao(DaoFactory.HIBERNATE).update(employee);
	}

}
