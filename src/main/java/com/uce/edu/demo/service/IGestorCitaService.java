package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.PacienteSencillo;


public interface IGestorCitaService {

	public void agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente);
	
	public void actualizar(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita);
	
	public List<PacienteSencillo> buscarFechaGenero(LocalDateTime fechaNacimiento, String genero);

}
