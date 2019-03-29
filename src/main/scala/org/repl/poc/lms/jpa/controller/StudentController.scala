package org.repl.poc.lms.jpa.controller

import java.time.LocalDateTime

import javax.validation.Valid
import javax.websocket.server.PathParam
import org.repl.poc.lms.jpa.dto.EnrollmentRequestDto
import org.repl.poc.lms.jpa.model.Hotel
import org.repl.poc.lms.jpa.model.course.{CourseRegistration, Student}
import org.repl.poc.lms.jpa.repository.{CourseRegistrationRepository, CourseRepository, HotelRepository, StudentRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.ui.Model
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(value = Array("/api"))
class StudentController @Autowired()(private val studentRepository: StudentRepository,
                                     private val courseRepository: CourseRepository,
                                     private val courseRegistrationRepository: CourseRegistrationRepository) {
  @RequestMapping(value = Array("/v1/students"), method = Array(RequestMethod.GET))
  @ResponseBody
  def list() = {
    studentRepository.findAll()
  }

  @PostMapping(value = Array("/v1/students"), consumes = Array(MediaType.APPLICATION_JSON_VALUE), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  @ResponseBody
  def create(@Valid @RequestBody student: Student) =
    studentRepository.save(student)

  @PostMapping(value = Array("/v1/students/{studentId}/courses/{courseId}"), consumes = Array(MediaType.APPLICATION_JSON_VALUE), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  @ResponseBody
  def enroll(@PathVariable("studentId") studentId : String, @PathVariable("courseId") courseId : String): Unit = {
    var student = studentRepository.findById(studentId.toLong)
    if (student != null) {
      val course = courseRepository.findById(courseId.toLong)
      if (course != null) {
        val courseReg = new CourseRegistration()
        courseReg.student = student.get()
        courseReg.course = course.get()
        courseReg.registeredAt = LocalDateTime.now()
        courseReg.grade = -1
        courseRegistrationRepository.save(courseReg)
      }
    }
  }

  @RequestMapping(value = Array("/v1/students/{studentId}/courses"), method = Array(RequestMethod.GET))
  @ResponseBody
  def listCourses(@PathVariable("studentId") studentId : String) = {
    var student = studentRepository.findById(studentId.toLong)
    if (student != null) {
      student.get().registrations.stream().map(_.course).toArray
    }
  }
}
