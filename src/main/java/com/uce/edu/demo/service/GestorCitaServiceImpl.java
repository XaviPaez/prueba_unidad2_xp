package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;

@Service
public class GestorCitaServiceImpl implements IGestorCitaService {

	@Autowired
	private IDoctorRepository doctorRepository;
	@Autowired
	private IPacienteRepository iPacienteRepository;
	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;
	
	@Override
	public void agendarCita(String numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		CitaMedica citaMedica=new CitaMedica();
		citaMedica.setNumeroCita(numeroCita);
		citaMedica.setFechaCita(fechaCita);
		citaMedica.setValorCita(valorCita);
		citaMedica.setLugarCita(lugarCita);
		
		Doctor doctor=this.doctorRepository.buscarPorCedula(cedulaDoctor);
		citaMedica.setDoctor(doctor);
		
		Paciente paciente=this.iPacienteRepository.buscarPorCedula(cedulaPaciente);
		citaMedica.setPaciente(paciente);
		
		this.citaMedicaRepository.insertar(citaMedica);
		

	}

	@Override
	public void actualizar(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
	
		CitaMedica citaMedica=this.citaMedicaRepository.buscarPorNumeroCita(numeroCita);
		citaMedica.setDiagnostico(diagnostico);
		citaMedica.setFechaProximaCita(fechaProximaCita);
		citaMedica.setReceta(receta);
		
		this.citaMedicaRepository.actualizar(citaMedica);
	}

	@Override
	public List<PacienteSencillo> buscarFechaGenero(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.buscarPorFechaGenero(fechaNacimiento, genero);
		
	}

}
