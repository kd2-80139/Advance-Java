package com.app.testers;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.List;
public class GetAllEmployee {
	public static void main(String[] args) {
		try(SessionFactory sf=getFactory()){
			List<Employee> list=null;
			EmployeeDaoImpl edao=new EmployeeDaoImpl();
			list=edao.getAllEmps();
			list.forEach((e)->{
				System.out.println(e);
			});
		}
	}
}
