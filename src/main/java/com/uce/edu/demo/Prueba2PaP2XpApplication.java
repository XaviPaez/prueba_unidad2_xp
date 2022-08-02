package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteSencillo;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class Prueba2PaP2XpApplication implements CommandLineRunner {

	private static Logger LOG= Logger.getLogger(Prueba2PaP2XpApplication.class);
	
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private IPacienteService iPacienteService;
	@Autowired
	private IGestorCitaService citaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba2PaP2XpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		

		//1. Funcionalidad CRUD para doctores
		Doctor doctor = new Doctor();
		doctor.setNombre("Sebastian");
		doctor.setApellido("Acosta");
		doctor.setCedula("12345678");
		doctor.setFechaNacimiento(LocalDateTime.now());
		doctor.setCodigoSenescyt("2000-1S");
		doctor.setGenero("Masculino");
		doctor.setNumeroConsultorio("3B");
		
		Doctor doctor1 = new Doctor();
		doctor1.setNombre("Valeria");
		doctor1.setApellido("Acosta");
		doctor1.setCedula("01234753");
		doctor1.setFechaNacimiento(LocalDateTime.now());
		doctor1.setCodigoSenescyt("2022-B");
		doctor1.setGenero("Femenino");
		doctor1.setNumeroConsultorio("1B");
	//	this.doctorService.insertar(doctor);
	//	this.doctorService.insertar(doctor1);

	
		//2. Funcionalidad CRUD para pacientes
		Paciente paciente = new Paciente();
		paciente.setNombre("Josue");
		paciente.setApellido("Nolivos");
		paciente.setCedula("42198391");
		paciente.setFechaNacimiento(LocalDateTime.now());
		paciente.setCodigoSeguro("0001-A");
		paciente.setGenero("Masculino");
		paciente.setPeso(55.4);
		paciente.setEstatura(1.70);
	
		Paciente paciente1 = new Paciente();
		paciente1.setNombre("Martina");
		paciente1.setApellido("Carpio");
		paciente1.setCedula("18923791");
		paciente1.setFechaNacimiento(LocalDateTime.now());
		paciente1.setCodigoSeguro("005601-D");
		paciente1.setGenero("Femenino");
		paciente1.setPeso(50);
		paciente1.setEstatura(1.60);
	//	this.iPacienteService.insertar(paciente);
	//	this.iPacienteService.insertar(paciente1);
		
		
		//3. Agendamiento cita medica
		//this.citaService.agendarCita("1", LocalDateTime.now(), new BigDecimal(15), "EasyLab", doctor1.getCedula(), paciente1.getCedula());
		//4. Actualizacion cita medica
		//this.citaService.actualizar("1", "Gripe", "Ibuprofeno", LocalDateTime.now());
		
		//Punto 5
		List<PacienteSencillo> lista =this.citaService.buscarFechaGenero(LocalDateTime.of(2022, 7, 28, 7, 55), "Masculino");
        LOG.debug("Cantidad de registros consultados: " + lista.size());
        for (PacienteSencillo pacienteSencillo : lista) {
            LOG.debug("Paciente Sencillo: " + pacienteSencillo);
        }

	}
}
