package com.cg.java.tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.java.services.EmpServices;
import com.cg.java.services.SalaryServices;


/*The bean declaration is done using @Component
 * The initial value can be hard coded using @Value
 * There are 3 types of injections 
 * 	The Field Injection:Give @Autowired to field
 * 	The constructor Injection: Give @Autowired to constructor
 * 	The setter Injection: Give @Autowired to setter method
		
	Bean Injections:
		byType:searches a bean 
		
	*/





public class Test010_Context {

	public static void main(String[] args) {
		//create spring context,spring container.
		//BeanFactory factory= new XmlBeanFactory();
		//ApplicationContext is modified version of BeanFactory
		//From spring 4.3 onwards,BeanFactory is deprecated
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springCore.xml");
		//This object is singleton by default
		System.out.println("**********************");
		EmpServices services1 = (EmpServices)ctx.getBean("empServices");
		EmpServices services2 = (EmpServices)ctx.getBean("empServices");
		System.out.println(services1.getMessage());
		System.out.println(services2.getMessage());
		System.out.println(services1.getAddress());
						
		/*SalaryServices service3=(SalaryServices)ctx.getBean("salServices");
		System.out.println(service3.calcSalary());*/
		
		ConfigurableApplicationContext cctx=(ConfigurableApplicationContext)ctx;
		cctx.close();
	}

}
