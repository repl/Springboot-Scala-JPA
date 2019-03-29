package org.repl.poc.lms.jpa.controller

import org.repl.poc.lms.jpa.model.Customer
import org.repl.poc.lms.jpa.repository.CustomerRepository
import org.springframework.web.bind.annotation._
import scala.collection.JavaConverters._
// This controller uses constructor injection

@RestController
@RequestMapping(Array("/api/v1/customers"))
class CustomerController (
  private val customerRepository: CustomerRepository
) {

  // Have to use arrays in annotations, which is a pain

  @GetMapping(value = Array("/{id}"), produces = Array("application/json"))
  def getCustomer(@PathVariable("id") id: Long) = customerRepository.findById(id)

  @GetMapping(produces = Array("application/json"))
  def getAllCustomers() = customerRepository.findAll()

  @GetMapping(value = Array("/formatted"), produces = Array("application/json"))
  def getAllCustomersFormatted() = {
    // Use JavaConverters to move between Scala and Java collections.
    customerRepository
      .findAll()
      .asScala
      .map(_.toString())
      .asJava
  }

  @PostMapping(produces = Array("application/json"), consumes = Array("application/json"))
  def addCustomer(@RequestBody customer: Customer) = customerRepository.save(customer)

  @GetMapping(value = Array("/{id}/pets"), produces = Array("application/json"))
  def getPets(@PathVariable("id") id: Long) = {
    val customer = customerRepository.findById(id)
    customer.get().pets
  }
}
