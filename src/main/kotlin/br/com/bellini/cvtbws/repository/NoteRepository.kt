package br.com.bellini.cvtbws.repository

import br.com.bellini.cvtbws.Model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, Long>