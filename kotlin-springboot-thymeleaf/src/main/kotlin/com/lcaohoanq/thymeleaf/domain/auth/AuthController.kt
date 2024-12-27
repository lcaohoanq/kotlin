package com.lcaohoanq.thymeleaf.domain.auth

import com.lcaohoanq.thymeleaf.domain.user.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.util.UUID

@Controller
class AuthController {
    
    val account = mutableListOf(
        User(UUID.randomUUID(), "hehe", "1"),
        User(UUID.randomUUID(), "haha", "1")
    )

    @GetMapping("/auth")
    fun entryPoint(model: Model): String {
        model.addAttribute("user", AuthPort.LoginRequest())
        return "auth"
    }

    @PostMapping("/auth/login")
    fun login(
        @ModelAttribute user: AuthPort.LoginRequest
    ): String {
        val user = account.find { it.username == user.username }
        return if (user != null) {
            "redirect:/" //index.html
        } else {
            "redirect:/auth"
        }
    }
    
    @GetMapping("/auth/register")
    fun registerEntryPoint(model: Model): String {
        model.addAttribute("user", AuthPort.RegisterRequest())
        return "register"
    }

    @PostMapping("/auth/register")
    fun register(
        @ModelAttribute user: AuthPort.RegisterRequest
    ): String {
        account.add(User(UUID.randomUUID(), user.username, user.password))
        return "redirect:/auth"
    }

}