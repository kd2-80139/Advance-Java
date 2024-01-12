package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class GetEmployee {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			EmployeeDaoImpl edao=new EmployeeDaoImpl();
			System.out.println("enter empId");
			Employee e=edao.getEmpDetailsById(sc.nextInt());
			System.out.println(e);
		}
	}
}
