package org.repl.poc.lms.jpa.repository

import org.springframework.data.repository.CrudRepository
import java.lang.Long

import org.repl.poc.lms.jpa.model.Hotel

trait HotelRepository extends CrudRepository[Hotel, Long]