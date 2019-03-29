package org.repl.poc.lms.jpa.model.course

import java.time.LocalDateTime

import javax.persistence._

import scala.beans.BeanProperty

@Entity
@Table(name = "course_registration")
class CourseRegistration {
    @Id
    @GeneratedValue
    @BeanProperty
    var id: Long = _

    @ManyToOne
    //@MapsId("student_id")
    @JoinColumn(name = "student_id", nullable = false)
    @BeanProperty
    var student: Student = _

    @ManyToOne
    //@MapsId("course_id")
    @JoinColumn(name = "course_id", nullable = false)
    @BeanProperty
    var course: Course = _

    @Column(name = "registered_at")
    @BeanProperty
    var registeredAt: LocalDateTime = _

    @BeanProperty
    var grade: Int = _
}
