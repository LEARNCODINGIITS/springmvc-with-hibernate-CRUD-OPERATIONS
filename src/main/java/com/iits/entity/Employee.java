package com.iits.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name = "eid")
	private int id;// 0
    @Column(name="ename")
	private String name;//
    @Column(name="esalary")
	private double salary;// 0.0

	public Employee() {
		super();
	}

	public int getId() {
		return id;// 0
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
