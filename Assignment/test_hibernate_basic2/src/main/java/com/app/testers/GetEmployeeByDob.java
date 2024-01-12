package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;
import static java.time.LocalDate.parse;
import static com.app.utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;
public class GetEmployeeByDob {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			List<Employee> list=null;
			EmployeeDaoImpl edao=new EmployeeDaoImpl();
			list=edao.getAllEmpByJoinDate(parse(sc.next()));
			list.forEach((e)->{
				System.out.println(e);
			});
		}
	}
}
