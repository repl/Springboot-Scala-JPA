package org.repl.poc.lms.jpa.controller

import javax.validation.Valid
import org.repl.poc.lms.jpa.model.course.{Course, Student}
import org.repl.poc.lms.jpa.repository.{CourseRepository, HotelRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.ui.Model
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(value = Array("/api"))
class CourseController @Autowired()(private val courseRepository: CourseRepository) {
  @RequestMapping(value = Array("/v1/courses"), method = Array(RequestMethod.GET))
  @ResponseBody
  def list() = {
    courseRepository.findAll()
  }

  @RequestMapping(value = Array("/v1/courses/{courseId}"), method = Array(RequestMethod.GET))
  @ResponseBody
  def get(@PathVariable courseId: String) = {
    courseRepository.findById(courseId.toLong)
  }

  @PostMapping(value = Array("/v1/courses"), consumes = Array(MediaType.APPLICATION_JSON_VALUE), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  @ResponseBody
  def create(@Valid @RequestBody course: Course) =
    courseRepository.save(course)
}
