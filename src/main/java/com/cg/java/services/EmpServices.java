package com.cg.java.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/*
 * The interface initializingBean imposes implementation of method 
 * afterPropertiesSet(). This method gets called automatically after setting all 
 * properties
 * 
 * The interface DisposableBean imposes implementation of method destroy()
 * This method gets automatically called while bean is removed from spring context.
 * 
 */
@Component("empServices")
public class EmpServices /*implements InitializingBean,DisposableBean*/{
//	@Value("Capgemini,Pune")
	private String companyName;
//	@Value("Talwade")
	private String address;
//	@Autowired
	private SalaryServices services;
	@Value("5000000")//Field Injection
	private float yrlyPackage;
	
	public EmpServices()
	{
		System.out.println("EmpService object created.");
	}
	public EmpServices(String companyName,String address)
	{
		super();
		System.out.println("In two para constructor");
		this.companyName=companyName;
		this.address=address;
	}
	public EmpServices(String companyName,String address,float yPackage)
	{
		super();
		System.out.println("In three para constructor");
		this.companyName=companyName;
		this.address=address;
		this.yrlyPackage=yPackage;
	}
	public String getMessage()
	{
		System.out.println(services.calcSalary());
		return "welcome Spring training!"+ companyName+yrlyPackage;
	}
	
	//Properties
	public String getCompanyName() {//companyName
		return companyName;
	}
	@Value("Capgemini,Pune")//setter Injection
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}
	@Value("Talwade")
	public void setAddress(String address) {//address->property name
		this.address = address;
	}
	public SalaryServices getServices() {//services
		return services;
	}
	@Autowired
	@Qualifier("salServices")//By Name
	//byType:Find the bean as per the type and not on "id"
	//byName:Find the bean on the basis of id
	
	public void setServices(SalaryServices services) {
		this.services = services;
	}
	public float getYrlyPackage() {
		return yrlyPackage;
	}
	public void setYrlyPackage(float yrlyPackage) {
		this.yrlyPackage = yrlyPackage;
	}
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("In afterPropertiesSet() method");
		
	}
	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("In destroy() method");
	}
	
}
