package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Questiontype;

@Repository
public class QuestionTypeDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void InsertQuestionType(Questiontype questiontype){
		
		manager.persist(questiontype);
		
	}
	
	@Transactional
	public void deleteQuestiontype(long idQuestiontype){
		
		Questiontype questiontype = manager.find(Questiontype.class, idQuestiontype);
		
		manager.remove(questiontype);
		
	}
	
	public List<Questiontype> findQuestiontype(){
	
		TypedQuery<Questiontype> query = manager.createQuery("SELECT qt FROM Questiontype qt", Questiontype.class);
		
		return query.getResultList();
		
	}
	
	public List<Questiontype> findQuestiontypeById(long idQuestiontype){
		
		TypedQuery<Questiontype> query = manager.createQuery("SELECT qt FROM Questiontype qt WHERE qt.id = :id", Questiontype.class);
		query.setParameter("id", idQuestiontype);
		
		return query.getResultList();
		
		
	}
	
}
