package org.repl.poc.lms.jpa.model.course

import java.util

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence._

import scala.annotation.meta.field
import scala.beans.BeanProperty;

@Entity
@Table(name = "student")
class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var name: String = _

  @(JsonIgnore@field)
  @(OneToMany@field)(mappedBy = "student")
  @BeanProperty
  var likedCourses: util.List[LikedCourse] = _

  @(JsonIgnore@field)
  @(OneToMany@field)(mappedBy = "student")
  @BeanProperty
  var ratings: util.List[CourseRating] = _

  @(JsonIgnore@field)
  @(OneToMany@field)(mappedBy = "student")
  @BeanProperty
  var registrations: util.List[CourseRegistration] = _
}
