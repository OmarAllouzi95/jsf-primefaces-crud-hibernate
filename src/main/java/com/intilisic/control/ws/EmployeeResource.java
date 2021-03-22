package com.intilisic.control.ws;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.intilisic.core.EmployeeBusiness;
import com.intilisic.core.exception.BusinessException;
import com.intilisic.dto.Employee;

@Path("/employees")
public class EmployeeResource {

	EmployeeBusiness business = new EmployeeBusiness();
	protected static final String MEDIA_TYPE_APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON + ";charset=utf-8";

	@GET
	@Produces(MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public List<Employee> list() {
		return business.getAllEmployees();
	}

	@GET
	@Path("{id}")
	@Produces(MEDIA_TYPE_APPLICATION_JSON_UTF8)
	public Response get(@PathParam("id") long id) {

		Optional<Employee> employee = business.getById(id);
		if (employee == null || !employee.isPresent()) {
			return Response.status(Status.NO_CONTENT).build();
		}

		return Response.status(Status.OK).entity(employee.get()).build();
	}

	@POST
	@Consumes(MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public Response add(Employee employee) throws URISyntaxException {

		business.save(employee);
		return Response.status(Status.CREATED).entity(employee.getId()).build();
	}

	@PUT
	@Consumes(MEDIA_TYPE_APPLICATION_JSON_UTF8)
	@Path("{id}")
	public Response update(@PathParam("id") long id, Employee employee) {

		employee.setId(id);
		try {
			business.update(employee);
			return Response.status(Status.OK).build();
		} catch (BusinessException e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}

	@DELETE
	public Response delete(Employee employee) {

		try {
			business.delete(employee);
			return Response.status(Status.OK).build();
		} catch (BusinessException e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}

}
