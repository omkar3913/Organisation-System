package com.jbk.OrganizationSystem.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.OrganizationSystem.Dao.MainDao;
import com.jbk.OrganizationSystem.entity.Country;
import com.jbk.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;

	public String addCountry(Country c) {
		// TODO Auto-generated method stub

		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			return "country is not added";
		}

		return msg;

	}

	public String updateCountry(Country c, int id) {
		// TODO Auto-generated method stub

		String msg = dao.updateCountry(c, id);
		if (Objects.isNull(msg)) {
			return "country is not updated";
		}
		return msg;

	}

	public String deleteCountry(int id) {
		// TODO Auto-generated method stub
		String msg = dao.deleteCountry(id);
		if (Objects.isNull(msg)) {
			return "country is not deletd";
		}

		return msg;

	}

	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		List<Country> list = dao.getAllCountry();
		if (list.isEmpty() == true) {
			return null;
		}
		return list;

	}

	public String addEmp(Employee emp) {
		// TODO Auto-generated method stub
		String msg = dao.addEmp(emp);

		if (Objects.isNull(msg)) {
			msg = "Record is not be addedd...";
		}
		return msg;
	}

	public String updateEmp(Employee e) {
		// TODO Auto-generated method stub
		String msg = dao.updateEmp(e);
		if (Objects.isNull(msg)) {
			return "employee not updated";
		}
		return msg;
	}

	public String deleteEmp(int id) {
		// TODO Auto-generated method stub
		String msg = dao.deleteEmp(id);
		if (Objects.isNull(msg)) {
			return "employee not deleted";
		}
		return msg;
	}

	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> list = dao.getAllEmp();
		if (list.isEmpty() == true) {
			return null;
		}
		return list;

	}

	public Employee getEmpById(int id) {

		Employee emp = dao.getEmpById(id);
		if (Objects.isNull(emp)) {
			emp = null;
		}
		return emp;

	}

	public List<Employee> getEmpByStatus(String status) {
		// TODO Auto-generated method stub

		List<Employee> list = dao.getEmpByStatus(status);
		if (list.isEmpty()) {
			return null;
		}
		return list;

	}

	public HashMap loginapi(Employee e) {

		Employee emp = dao.loginapi(e);
		HashMap map = new HashMap();

		if (Objects.isNull(emp)) {
			map.put("msg", "invalid user");
			map.put("user", emp);
		} else {
			map.put("msg", "valid user");
			map.put("user", emp);
		}

		return map;

	}

	public List<Employee> getEmpBySalary(double salary) {
		// TODO Auto-generated method stub

		List<Employee> list = dao.getEmpBySalary(salary);
		if (Objects.isNull(list)) {
			list = null;
		}
		return list;

	}

}
