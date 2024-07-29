package com.jbk.OrganizationSystem.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.OrganizationSystem.entity.Country;
import com.jbk.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			session.persist(c);

			tx.commit();
			msg = "country added  succesfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;

	}

	public String updateCountry(Country c, int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);
			country.setCname(c.getCname());

			session.merge(country);
			tx.commit();
			msg = "country updated succesfully";

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteCountry(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);

			session.remove(country);
			msg = "country deleted succesfully";
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String Query = null;
		List<Country> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query = "from Country";

			Query<Country> query = session.createQuery(Query, Country.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public String addEmp(Employee emp) {
		// TODO Auto-generated method stu
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee Addedd Successully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmp(Employee e) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee emp = session.get(Employee.class, e.getId());

			emp.setCountry(e.getCountry());
			emp.setCreatedby(e.getCreatedby());
			emp.setCreateddtm(e.getCreateddtm());
			emp.setDepartment(e.getDepartment());
			emp.setEmailid(e.getEmailid());
			emp.setGender(e.getGender());
			emp.setName(e.getName());
			emp.setPhoneno(e.getPhoneno());
			emp.setSalary(e.getSalary());
			emp.setStatus(e.getStatus());
			emp.setUpdatedby(e.getUpdatedby());
			emp.setUpdateddtm(e.getUpdateddtm());

			session.merge(emp);

			msg = "employee updated succesfully";
			tx.commit();

		} catch (Exception e3) {
			if (tx != null) {
				tx.rollback();
			}
			e3.printStackTrace();

			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return msg;

	}

	public String deleteEmp(int id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee emp = session.get(Employee.class, id);

			session.remove(emp);
			msg = "employee deleted succesfully";
			tx.commit();

		} catch (Exception e3) {
			if (tx != null) {
				tx.rollback();
			}
			e3.printStackTrace();

			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return msg;
	}

	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String Query = null;
		List<Employee> list = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Query = "from Employee";
			Query<Employee> query = session.createQuery(Query, Employee.class);
			list = query.list();
			tx.commit();

		} catch (Exception e3) {
			if (tx != null) {
				tx.rollback();
			}
			e3.printStackTrace();

			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;
	}

	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			emp = session.get(Employee.class, id);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return emp;

	}

	public List<Employee> getEmpByStatus(String status) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		String hqlQuery = null;
		Query<Employee> query = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			hqlQuery = "from Employee where status=:mystatus";

			query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mystatus", status);

			list = query.list();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	public Employee loginapi(Employee e) {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = null;
		Query<Employee> query = null;
		Employee employee = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			hqlQuery = "from Employee where emailid=:myemailid and phoneno=:myphoneno";

			query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("myemailid", e.getEmailid());
			query.setParameter("myphoneno", e.getPhoneno());

			employee = query.uniqueResult();

			tx.commit();

		} catch (Exception e2) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;

	}

	public List<Employee> getEmpBySalary(double salary) {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = null;
		Query<Employee> query = null;
		// Employee employee = null;
		List<Employee> list = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			hqlQuery = "from Employee where salary>:mysalary";

			query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mysalary", salary);
			list = query.list();

			tx.commit();

		} catch (Exception e2) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

}
