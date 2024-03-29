package com.hospital.apphospital.web;

import java.util.List;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.apphospital.Entities.Patient;
import com.hospital.apphospital.repository.PatientRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;


    
    @GetMapping("/index")
    public String index(Model model , 
    @RequestParam(name = "page" , defaultValue = "0") int page,
    @RequestParam(name = "size" , defaultValue = "5") int size,
    @RequestParam(name = "keyword" ,defaultValue="" ) String keyword

    ) {
        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword, PageRequest.of(page , size));
        model.addAttribute("listePatient", pagePatients.getContent());
        model.addAttribute("pages", new int [pagePatients.getTotalPages()]);
        model.addAttribute("curerentPage", page); 
        model.addAttribute("keyword", keyword);
           return "patients";
    }

    @GetMapping("/delete")
    public String  deletePatient (Long id ){
        patientRepository.deleteById(id);
        return "redirect:/index";
    }



    @GetMapping("/formPatient")
    public String formPatient( Model model){
        model.addAttribute("patient", new Patient());
      //  patientRepository.save(p);
        return "formPatient";
    }


    @PostMapping("/savePatient")
    public String  savePatient(@Valid Patient p , BindingResult bindResult){
        if(bindResult.hasErrors()){
            return "formPatient";
        }else{
        patientRepository.save(p);
        return "redirect:/index";
    }

    }

}
