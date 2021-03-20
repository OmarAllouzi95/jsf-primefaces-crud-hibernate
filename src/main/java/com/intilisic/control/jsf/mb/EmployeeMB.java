package com.intilisic.control.jsf.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.intilisic.core.EmployeeBusiness;
import com.intilisic.dto.Employee;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecation")
@ViewScoped
@ManagedBean
public class EmployeeMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Employee> employees;
	private EmployeeBusiness employeeBusiness;
	private Employee employee;

	public EmployeeMB() {
		employeeBusiness = new EmployeeBusiness();
		employee = new Employee();
	}

	@PostConstruct
	public void init() {
		this.employees = employeeBusiness.getAllEmployees();
	}

	public void delete(Employee employee) {
		employeeBusiness.delete(employee);
		this.employees = employeeBusiness.getAllEmployees();

	}

	public Employee getById() {

		Optional<Employee> optEmployee = employeeBusiness.getById(employee.getId());
		if (optEmployee == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No Employee Found"));
			this.employee = new Employee();
		} else {
			this.employee = optEmployee.get();
		}

		return this.employee;
	}

	public void add() {
		employeeBusiness.save(employee);
		this.employees = employeeBusiness.getAllEmployees();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New Employee Added Successfully"));
		this.employee = new Employee();
	}

	public void update() {
		employeeBusiness.update(employee);
		this.employees = employeeBusiness.getAllEmployees();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
