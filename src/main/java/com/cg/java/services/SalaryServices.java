package com.cg.java.services;

import org.springframework.stereotype.Component;

@Component("salServices")
public class SalaryServices {
	public SalaryServices()
	{
		System.out.println("Object salary services created");
	}
	public String calcSalary()
	{
		return "salary calculated";
	}
}
