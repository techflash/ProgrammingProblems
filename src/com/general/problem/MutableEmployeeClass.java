package com.general.problem;

import java.util.Date;

final public class MutableEmployeeClass {
	private int id;
	private String name;
	private Date dob;

	public MutableEmployeeClass(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public MutableEmployeeClass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "MutableEmployeeClass [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDob() {
		return new Date(dob.getTime());
	}

}
