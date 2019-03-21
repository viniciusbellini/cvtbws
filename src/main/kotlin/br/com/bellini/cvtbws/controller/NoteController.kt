package br.com.bellini.cvtbws.controller

import br.com.bellini.cvtbws.Model.Note
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Controller
@RequestMapping("notes")
class NoteController {

    @GetMapping
    fun list(): List<Note>{
        return listOf(Note("Leitura", "Livro Spring Boot"),
                Note("Pesquisa", "Ambiente com Docker"))
    }
}