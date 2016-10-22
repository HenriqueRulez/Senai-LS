package br.senai.informatica.leansurvey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.informatica.leansurvey.model.Gender;

@Repository
public class GenderDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertGenderDao(Gender gender){
		
		manager.persist(gender);
		
	}
	
	@Transactional
	public void updateGender(String description, long id){
		
		Gender gender = manager.find(Gender.class, id);
		gender.setDescription(description);
		manager.merge(gender);
		
	}
	
	@Transactional
	public void deleteGender(long idGender){
		
		Gender gender = manager.find(Gender.class, idGender);
		manager.remove(gender);
		
	}
	
	public List<Gender> findGender(){
		
		TypedQuery<Gender> query = manager.createQuery("SELECT g FROM Gender g", Gender.class);
		
		return query.getResultList();
		
	}
	
	public List<Gender> findGenderById (long idGender){
		
		TypedQuery<Gender> query = manager.createQuery("SELECT g FROM Gender g WHERE g.id = :id", Gender.class);
		query.setParameter("id", idGender);
		
		return query.getResultList();
	}
	
}
