package org.id.SpringMVC.contoller;

import org.id.SpringMVC.dao.PatientRepository;
import org.id.SpringMVC.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JSONController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/listPatients")

    public List<Patient> list() {
        return patientRepository.findAll() ;
    }
    @GetMapping(path = "/patient/{id}")

    public Patient getOne(@PathVariable Long id) {
        return patientRepository.findById(id).get();
    }
}