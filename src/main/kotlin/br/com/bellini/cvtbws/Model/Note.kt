package br.com.bellini.cvtbws.Model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Note (@Id
            @GeneratedValue
            val id: Long = 0L,
            val title: String,
            val description: String) {
    constructor() : this(0,"","")
}