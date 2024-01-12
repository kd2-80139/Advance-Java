package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class DeleteEmployee {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			EmployeeDaoImpl edao=new EmployeeDaoImpl();
			edao.deleteEmpDetailsById(sc.nextInt());
		}
	}
}
