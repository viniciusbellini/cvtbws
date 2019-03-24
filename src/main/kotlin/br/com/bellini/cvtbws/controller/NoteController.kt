package br.com.bellini.cvtbws.controller

import br.com.bellini.cvtbws.model.Note
import br.com.bellini.cvtbws.repository.NoteRepository
import br.com.bellini.cvtbws.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("notes")
class NoteController (private val noteService: NoteService){

    @GetMapping
    fun list(): ResponseEntity<List<Note>>{
        val allNotes = noteService.all().toList()
        return ResponseEntity.ok(allNotes)
    }

    @PostMapping
    fun add(@RequestBody note: Note): ResponseEntity<Note>{
        val savedNote = noteService.save(note)
        return ResponseEntity.ok(savedNote)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note>{
        if (noteService.existsById(id)) {
            val alterNote = noteService.alter(id, note)
            return ResponseEntity.ok(alterNote)
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit>{
        if (noteService.existsById(id)){
            noteService.deleteById(id)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}