package com.iits.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.iits.entity.Employee;

@Service
@EnableTransactionManagement
public class EmployeeDAO {
	@Autowired
	HibernateTemplate hibernateTemplate;

	public EmployeeDAO() {
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void saveEmployee(Employee employee) {
		this.hibernateTemplate.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return this.hibernateTemplate.loadAll(Employee.class);

	}

	@Transactional
	public void deleteById(int id) {
		Employee emp = this.hibernateTemplate.load(Employee.class, id);

		this.hibernateTemplate.delete(emp);

	}

	public Employee getEmployee(int id) {
		Employee emp = this.hibernateTemplate.get(Employee.class, id);
		return emp;

	}
    @Transactional
	public void updateEmployee(Employee employee) {
	   this.hibernateTemplate.saveOrUpdate(employee);
	}

}
