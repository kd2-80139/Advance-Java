package com.app.dao;

import com.app.pojos.Employee;
import com.app.pojos.EmployeeType;

import static com.app.utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee emp) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable id = session.save(emp);
			tx.commit();

		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

	}

	@Override
	public Employee getEmpDetailsById(Integer empId) {
		// TODO Auto-generated method stub
		Employee emp = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			emp = session.get(Employee.class, empId);
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return emp;

	}

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> list = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "select e from Employee e";
			list = session.createQuery(jpql, Employee.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return list;
	}

	@Override
	public List<Employee> getAllEmpByJoinDate(LocalDate start) {
		List<Employee> list = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "select e from Employee e where e.dob=:date";
			list = session.createQuery(jpql, Employee.class).setParameter("date", start).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return list;
	}

	@Override
	public List<String> getLastNamesByEmpType(EmployeeType type) {
		// TODO Auto-generated method stub
		List<String> list = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "select e.lastName from Employee e where e.type=:ty";
			list = session.createQuery(jpql, String.class).setParameter("ty", type).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return list;
	}

	@Override
	public List<Employee> getAllEmpsByType(EmployeeType type) {
		// TODO Auto-generated method stub
		List<Employee> list = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "select e from Employee e where e.type=:ty";
			list = session.createQuery(jpql, Employee.class).setParameter("ty", type).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return list;
	}

	@Override
	public String updateEmpSalary(String email, String name) {
		// TODO Auto-generated method stub
		String s = "Sal Not Updated";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "select e from Employee e where e.email=:email";
			Employee e = session.createQuery(jpql, Employee.class).setParameter("email", email).getSingleResult();
			e.setFirstName(name);
			tx.commit();
			s = "Sal Updated";
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return s;
	}

	@Override
	public String bulkUpdateSalaryByJoinDate(LocalDate joinDate, String name) {
		// TODO Auto-generated method stub
		String msg = "All updated";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			String jpql = "update Employee e set e.lastName=:name where e.dob=:joinDate";
			session.createQuery(jpql).setParameter("name", name).setParameter("joinDate", joinDate).executeUpdate();
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteEmpDetailsById(Integer empId) {
		// TODO Auto-generated method stub
		String msg = "Deleted";
		Employee emp = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			emp = session.get(Employee.class, empId);
			session.delete(emp);
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return null;
	}

	@Override
	public String storeImage(Integer empid, String path) throws IOException {
	
		// TODO Auto-generated method stub
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Employee e = session.get(Employee.class, empid);
			System.out.println(e);
			if (e != null) {
				File file = new File(path);
//				System.out.println(path);
//				System.out.println(file.getAbsolutePath());
				
				if (file.isFile() && file.canRead()) {
					e.setImage(FileUtils.readFileToByteArray(file));

				}
			}
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return null;
	}

}
