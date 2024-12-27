package com.lcaohoanq.thymeleaf.domain.user

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import java.util.*


@Controller
class StudentController {
    private val users: MutableList<User?> = ArrayList()

    @GetMapping("/user")
    fun entryPoint(model: Model): String {
        model.addAttribute("users", users)
        model.addAttribute("user", User(UUID.randomUUID(), "alice@example.com", "123123"))
        return "user"
    }

    @PostMapping("/user/save")
    fun saveStudent(@ModelAttribute user: User): String {
        // If the user already exists (i.e., has the same UUID), update it
        users.removeIf { s: User? -> s!!.id == user.id }
        users.add(user)
        return "redirect:/"
    }

    @GetMapping("/user/edit/{id}")
    fun editStudent(@PathVariable id: UUID, model: Model): String {
        val user = users.stream().filter { s: User? -> s!!.id == id }.findFirst().orElse(null)
        if (user != null) {
            model.addAttribute("user", user)
        }
        model.addAttribute("users", users)
        return "user"
    }

    @GetMapping("/user/delete/{id}")
    fun deleteStudent(@PathVariable id: UUID): String {
        users.removeIf { s: User? -> s!!.id == id }
        return "redirect:/"
    }
}
