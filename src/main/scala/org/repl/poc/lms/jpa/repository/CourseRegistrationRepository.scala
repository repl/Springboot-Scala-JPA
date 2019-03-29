package org.repl.poc.lms.jpa.repository

import org.repl.poc.lms.jpa.model.course.CourseRegistration
import org.springframework.data.repository.CrudRepository

trait CourseRegistrationRepository extends CrudRepository[CourseRegistration, Long]{

}
