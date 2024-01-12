package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;
import static java.time.LocalDate.parse;
import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class BulkUpdate {
 public static void main(String[] args) {
	try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)){
		EmployeeDaoImpl edao=new EmployeeDaoImpl();
		edao.bulkUpdateSalaryByJoinDate(parse(sc.next()), sc.next());
	}
}
}
