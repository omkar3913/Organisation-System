package com.jbk.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.OrganizationSystem.Service.MainService;
import com.jbk.OrganizationSystem.entity.Country;
import com.jbk.OrganizationSystem.entity.Employee;
@CrossOrigin
@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;

	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {

		String msg = service.addCountry(c);

		return msg;
	}

	@PutMapping("updatecountry/{id}")
	public String updateCountry(@PathVariable int id, @RequestBody Country c) {

		String msg = service.updateCountry(c, id);
		return msg;
	}

	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {

		String msg = service.deleteCountry(id);

		return msg;
	}

	@GetMapping("getallcountry")
	public List<Country> getAllCountry() {

		List<Country> list = service.getAllCountry();
		return list;
	}

	@PostMapping("addemp")
	public String addEmp(@RequestBody Employee e) {

		String msg = service.addEmp(e);
		return msg;
	}

	@PutMapping("updateemp")
	public String updateEmp(@RequestBody Employee e) {

		String msg = service.updateEmp(e);
		return msg;
	}

	@DeleteMapping("deleteemp/{id}")
	public String deleteEmp(@PathVariable int id) {

		String msg = service.deleteEmp(id);

		return msg;
	}

	@GetMapping("getallemp")
	public List<Employee> getAllEmp() {

		List<Employee> list = service.getAllEmp();
		return list;
	}

	@GetMapping("getempbyid/{id}")
	public Employee getEmpById(@PathVariable int id) {

		Employee emp = service.getEmpById(id);
		return emp;

	}

	@GetMapping("getempbystatus/{status}")
	public List<Employee> getEmpByStatus(@PathVariable String status) {

		List<Employee> list = service.getEmpByStatus(status);

		return list;

	}

	@PostMapping("logincheck")
	public HashMap loginapi(@RequestBody Employee e) {

		HashMap hs = service.loginapi(e);
		return hs;
	}

	@GetMapping("getempbysalary/{salary}")
	public List<Employee> getEmpBySalary(@PathVariable double salary) {

		List<Employee> list = service.getEmpBySalary(salary);
		return list;
	}

}
