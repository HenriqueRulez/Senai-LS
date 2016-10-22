package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Enterprise;

@Repository
public class EnterpriseDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void InsertEnterprise(Enterprise enterprise){
		
		manager.persist(enterprise);
		
	}
	
	@Transactional
	public void deleteEnterprise(long idEnterprise){
		
		Enterprise enterprise = manager.find(Enterprise.class, idEnterprise);
		
		manager.remove(enterprise);
	}
	
	public List<Enterprise> findEnterprise(){
		
		TypedQuery<Enterprise> query = manager.createQuery("SELECT e FROM Enterprise e", Enterprise.class);
		
		return query.getResultList();
		
	}
	
	public List<Enterprise> findEnterpriseById (long idEnterprise){
		
		TypedQuery<Enterprise> query = manager.createQuery("SELECT e FROM Enterprise e WHERE e.id =:id", Enterprise.class);
		query.setParameter("id", idEnterprise);
		
		return query.getResultList();
	}
	
}
