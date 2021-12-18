package com.nit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, empid);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}
	
	
	public List<Employee> search( String keyword,String option)
	{
		if(option.equalsIgnoreCase("All") && keyword=="" )
		{
		String hql = "FROM Employee";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
		}
		else if(option.equalsIgnoreCase("name")) {
		String hql = "FROM Employee E WHERE E.name like  '"+keyword+"'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
		}
		else if(option.equalsIgnoreCase("email")) {
					
		String hql = "FROM Employee E WHERE E.email  like '"+keyword+"'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
			}
		else if(option.equalsIgnoreCase("phone"))
		{
		String hql = "FROM Employee E WHERE E.telephone  like '"+keyword+"'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
		}
		else if(option.equalsIgnoreCase("address")) {
					
		String hql = "FROM Employee E WHERE E.address  like '"+keyword+"'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
			}
	   else {
		String hql = "FROM Employee E WHERE E.course like  '"+keyword+"'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	}

}