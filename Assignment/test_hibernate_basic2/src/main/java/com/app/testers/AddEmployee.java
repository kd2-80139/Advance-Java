package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;
import com.app.pojos.EmployeeType;

import static com.app.utils.HibernateUtils.getFactory;

import static java.time.LocalDate.parse;
import java.util.Scanner;
public class AddEmployee {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc= new Scanner(System.in)){
			EmployeeDaoImpl edao=new EmployeeDaoImpl();
			System.out.println("enter");
			Employee emp=new Employee(sc.next(), sc.next(), sc.next(), sc.next(),parse(sc.next()),EmployeeType.valueOf(sc.next().toUpperCase()));
			edao.addEmployee(emp);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
