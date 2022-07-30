package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente paciente=this.buscar(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public Paciente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery=this.entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cedula= :datoCedula", Paciente.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
		
	}

	@Override
	public List<PacienteSencillo> buscarPorFechaGenero(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteSencillo> myQuery=this.entityManager.createQuery("SELECT new com.uce.edu.demo.repository.modelo.PacienteSencillo(p.cedula, p.nombre,p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento > :datoFecha AND p.genero= :datoGenero ", PacienteSencillo.class);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

}
