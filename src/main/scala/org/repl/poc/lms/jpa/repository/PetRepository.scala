package org.repl.poc.lms.jpa.repository

import org.repl.poc.lms.jpa.model.Pet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

// Need to specify java.lang.Long instead of Scala's Long

@Repository
trait PetRepository extends CrudRepository[Pet, java.lang.Long]
