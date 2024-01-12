package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;

import static com.app.utils.HibernateUtils.getFactory;

import java.io.IOException;
import java.util.Scanner;
public class InsertImage {
	public static void main(String[] args) {
		try(SessionFactory sf= getFactory();Scanner sc=new Scanner(System.in)){
			EmployeeDaoImpl edao=new EmployeeDaoImpl();
			int empid=sc.nextInt();
			sc.nextLine();
			String s=sc.nextLine();
			edao.storeImage(empid, s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
