package fr.formation.inti.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService{
	
	private final Log log = LogFactory.getLog(EmployeeService.class);
	@Autowired
	private IEmployeeDao dao ; 
	
	public EmployeeService() {
		log.info("----------- Creating new EmployeeService");
		// dao = new EmployeeDao(); 
		// objectif spring : supprimer la ligne sans provoquer un nullpointer
	}
	
	@Override
	public Integer save(Employee e) {
		return dao.save(e);
	}

	@Override
	public void update(Employee e) {
		dao.update(e);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		dao.beginTransaction();
		List<Employee> list = dao.findAll();
		dao.commitTransaction();
		dao.close();
		return list;
	}

	public IEmployeeDao getDao() {
		return dao;
	}

	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}
	
	

}
