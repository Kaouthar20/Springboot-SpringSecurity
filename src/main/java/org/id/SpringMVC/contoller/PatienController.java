package org.id.SpringMVC.contoller;

import org.id.SpringMVC.dao.PatientRepository;
import org.id.SpringMVC.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PatienController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(path = "/patients")
    public String patient(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size,
                          @RequestParam(name = "keyWord", defaultValue = "") String keyWord) {

        Page<Patient> pagePatient = patientRepository.findByNameContains(keyWord, PageRequest.of(page, size));
        model.addAttribute("pagePatient", pagePatient);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("keyWord", keyWord);
        model.addAttribute("pages", new int[pagePatient.getTotalPages()]);
        return "patient";
    }

    @GetMapping(path = "/delete")
    public String deletePatient(Long id, int size, int page, String keyWord) {
        patientRepository.deleteById(id);
        return "redirect:/patients?page=" + page + "&size=" + size + "&keyWord=" + keyWord;
    }

    @GetMapping(path = "/formPatient")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("mode","new");
        return "formPatient";
    }
    @PostMapping(path = "/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);

        return "confirmation";
    }
    @GetMapping(path ="/updatePatient" )
    public String updatePatient(Model model, Long id){
       Patient p= patientRepository.findById(id).get();
   model.addAttribute("patient",p);
        model.addAttribute("mode","update");
        return "formPatient";
    }
}