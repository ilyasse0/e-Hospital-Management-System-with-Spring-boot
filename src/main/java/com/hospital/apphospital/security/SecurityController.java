package com.hospital.apphospital.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SecurityController {

    
    @GetMapping("/403")
     public String notAutorised(){
        return "403";
    }
    
}
