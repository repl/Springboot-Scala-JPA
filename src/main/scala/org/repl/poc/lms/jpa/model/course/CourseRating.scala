package org.repl.poc.lms.jpa.model.course

import javax.persistence._

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
@Table(name = "course_rating")
class CourseRating {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @ManyToOne
  @MapsId("student_id")
  @JoinColumn(name = "student_id")
  @BeanProperty
  var student: Student = _

  @ManyToOne
  @MapsId("course_id")
  @JoinColumn(name = "course_id")
  @BeanProperty
  var course: Course = _

  @BeanProperty
  var rating: Int = _
}
