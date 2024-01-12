package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateUtils {
	private static SessionFactory factory;
	static {
		factory=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
//	private static SessionFactory factory;//creation of session factory
//	
//	//static init block to create singleton sf
//	static
//	{
//		System.out.println("Inside Static Block");
//		factory=new Configuration()//empty configuration is created
//				.configure()//reads hibernate config xml file and populates config
//				.buildSessionFactory();//builds instance of SF from the populated config
//		System.out.println("session factory is created");
//	}
//	public static SessionFactory getFactory() {
//		return factory;
//	}
	
	
}
