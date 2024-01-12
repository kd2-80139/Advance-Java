package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.EmployeeType;

import static com.app.utils.HibernateUtils.getFactory;
import java.util.Scanner;
public class GetLastNameByType {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
			EmployeeDaoImpl edao=new EmployeeDaoImpl();
			edao.getLastNamesByEmpType(EmployeeType.valueOf(sc.next().toUpperCase())).forEach((e)->{
				System.out.println(e);
			});
		}
	}
}
