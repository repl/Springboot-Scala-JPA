package org.repl.poc.lms.jpa.repository

import org.repl.poc.lms.jpa.model.course.Student
import org.springframework.data.repository.CrudRepository

trait StudentRepository extends CrudRepository[Student, Long] {

}
