package com.hospital.apphospital;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hospital.apphospital.Entities.Patient;
import com.hospital.apphospital.repository.PatientRepository;

@SpringBootApplication
public class ApphospitalApplication implements CommandLineRunner{


	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApphospitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Patient patient = new Patient();
		patient.setId(null);
		patient.setNom("John");
		patient.setDateNaissance(new Date());
		patient.setMalade(false);
		patient.setScore(12);


		Patient patient3 = Patient.builder()
	
		.nom("hamouda")
		.dateNaissance(new Date())
		.score(13)
		.malade(true)
		.build();

		//patientRepository.save(patient);
		//patientRepository.save(patient3);
		


	}

}
