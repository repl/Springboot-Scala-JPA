package org.repl.poc.lms.jpa.model.course

;

import java.util

import com.fasterxml.jackson.annotation.{JsonIgnore, JsonProperty}
import javax.persistence._

import scala.annotation.meta.field
import scala.beans.BeanProperty;

@Entity
@Table(name = "course")
class Course {
  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var name: String = _

  @JsonIgnore
  @OneToMany(mappedBy = "course")
  @BeanProperty
  var likes: util.List[LikedCourse] = _

  @JsonIgnore
  @OneToMany(mappedBy = "course")
  @BeanProperty
  var ratings: util.List[CourseRating] = _

  @JsonIgnore
  @OneToMany(mappedBy = "course")
  @BeanProperty
  var registrations: util.List[CourseRegistration] = _
}
