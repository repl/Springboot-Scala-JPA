package org.repl.poc.lms.jpa.repository

import org.repl.poc.lms.jpa.model.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

// Need to specify java.lang.Long instead of Scala's Long for some reason

@Repository
trait CustomerRepository extends CrudRepository[Customer, java.lang.Long] {
  def findByLastName(lastName: String): List[Customer]
}
