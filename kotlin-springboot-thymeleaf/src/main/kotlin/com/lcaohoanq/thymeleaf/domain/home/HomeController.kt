package com.lcaohoanq.thymeleaf.domain.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController{
    
    @GetMapping("/")
    fun entryPoint(): String {
        return "index"
    }
    
}