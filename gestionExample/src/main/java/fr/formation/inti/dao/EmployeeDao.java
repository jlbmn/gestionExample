package fr.formation.inti.dao;

import java.util.List;

import org.hibernate.query.Query;

import fr.formation.inti.entity.Employee;

public class EmployeeDao extends GenericDaoHibernate<Employee, Integer> implements IEmployeeDao {

	@Override
	public List<Employee> searchByNames(String firstName, String lastName) {
		Query<Employee> query = session.createQuery(
				"from " + Employee.class.getName() + " e where e.firstName= :firstName and e.lastName = :lastName", Employee.class);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}



}
