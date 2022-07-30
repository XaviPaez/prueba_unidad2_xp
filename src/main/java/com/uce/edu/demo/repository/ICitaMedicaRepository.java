package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

public interface ICitaMedicaRepository {
	
	public void insertar(CitaMedica citaMedica);

	public void actualizar(CitaMedica citaMedica);
	
	public CitaMedica buscarPorNumeroCita(String numeroCita);
}
