package org.repl.poc.lms.jpa.repository

import org.repl.poc.lms.jpa.model.course.Course
import org.springframework.data.repository.CrudRepository

trait CourseRepository extends CrudRepository[Course, Long]
