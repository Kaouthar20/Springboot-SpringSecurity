package org.id.SpringMVC;

import org.id.SpringMVC.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {
	@Autowired
private PatientRepository patientRepository;
	public static void main (String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*Patient patient1=patientRepository.save(new Patient(null,"Adam",new Date(),true));
		Patient patient2=patientRepository.save(new Patient(null,"Sami",new Date(),true));
		Patient patient3=patientRepository.save(new Patient(null,"David",new Date(),false));
		Patient patient4=patientRepository.save(new Patient(null,"Sara",new Date(),true));
		Patient patient5=patientRepository.save(new Patient(null,"Nadia",new Date(),false));
		patientRepository.findAll().forEach(patient -> {
			System.out.println(patient.getName());

			System.out.println(patient.isSick());
		});*/
	}
}
