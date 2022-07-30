package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarPorNumeroCita(String numeroCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery=this.entityManager.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroCita= :datonumeroCita", CitaMedica.class);
		myQuery.setParameter("datonumeroCita", numeroCita);
		return myQuery.getSingleResult();
	}

	
}
