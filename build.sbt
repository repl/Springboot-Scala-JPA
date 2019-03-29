name := """Springboot Scala JPA"""
version := "0.0.1-SNAPSHOT"

import Dependencies._
import sbt.Keys.libraryDependencies

lazy val springVersion = "2.1.3.RELEASE"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.repl",
      scalaVersion := "2.12.2",
      version      := "0.3.0"
    )),
    name := "spring-boot-scala-jpa",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % springVersion,
    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-actuator" % springVersion,

    libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-jpa" % springVersion,
    libraryDependencies += "com.h2database" % "h2" % "1.4.195",
    
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8",
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.8",
    libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8",
    libraryDependencies += "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % "2.9.8",
    libraryDependencies += "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.9.8",
    libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.9.8"
  )


// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
mainClass in (Compile, run) := Some("org.repl.poc.lms.jpa.Application")
