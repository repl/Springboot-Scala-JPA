package org.repl.poc.lms.jpa.model.course

import javax.persistence._

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
@Table(name = "liked_courses")
case class LikedCourse (
                         @(Id@field)
                         @(GeneratedValue@field)
                         @BeanProperty
                         var id: Long,

                         @(ManyToOne@field)
                         @(MapsId@field)("student_id")
                         @(JoinColumn@field)(name = "student_id")
                         @BeanProperty
                         var student: Student,

                         @(ManyToOne@field)
                         @(MapsId@field)("course_id")
                         @(JoinColumn@field)(name = "course_id")
                         @BeanProperty
                         var course: Course,
                       ) {

}
