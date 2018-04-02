package com.general.problem;

import java.util.Date;

public class Main {
	public static void main(String[] args) {

		MutableEmployeeClass mutableEmployeeClass = new MutableEmployeeClass(101, "sunil", new Date());
		System.out.println(mutableEmployeeClass);
		mutableEmployeeClass.getDob().setDate((int) System.currentTimeMillis());
		System.out.println(mutableEmployeeClass);
		
	}
}
