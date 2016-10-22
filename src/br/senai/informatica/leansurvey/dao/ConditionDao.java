package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Condition;

@Repository
public class ConditionDao {

	@PersistenceContext
	public EntityManager manager;
	
	@Transactional
	public void insertCondition(Condition condition){
		
		manager.persist(condition);
		
	}
	
	@Transactional
	public void deleteCondition(long idCondition){
		
		Condition condition = manager.find(Condition.class, idCondition);
		
		manager.remove(condition);
	}
	
	
	public List<Condition> findCondition(){
		
		TypedQuery<Condition> query = manager.createQuery("SELECT c FROM Condition c", Condition.class);
		
		return query.getResultList();
		
	}
	
	
	public List<Condition> findConditionById (long idCondition){
		
		TypedQuery<Condition> query = manager.createQuery("SELECT c FROM Condition c WHERE c.id = :id", Condition.class);
		query.setParameter("id", idCondition);
		
		return query.getResultList();
		
	}
	
	
	
	/**
	 * 
	 * 
	 * 		TIRAR DUVIDA DE DELETE ANINHADO.
	 * 		SELECT FROM E WHERE X.ID = Y.ID
	 * 
	 * 
	 */
	
}
