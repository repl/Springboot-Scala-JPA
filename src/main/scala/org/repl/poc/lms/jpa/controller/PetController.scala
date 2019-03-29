package org.repl.poc.lms.jpa.controller

import org.repl.poc.lms.jpa.dto.PetCreateRequestDto
import org.repl.poc.lms.jpa.model.Pet
import org.repl.poc.lms.jpa.repository.{CustomerRepository, PetRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

// This controller uses field injection

@RestController
@RequestMapping(Array("/api/v1/pets"))
class PetController {

  @Autowired
  var petRepository: PetRepository = null

  @Autowired
  var customerRepository: CustomerRepository = null

  @GetMapping(produces = Array("application/json"))
  def getAllPets = petRepository.findAll()

  @PostMapping(produces = Array("application/json"), consumes = Array("application/json"))
  def addPet(@RequestBody petCreateRequest: PetCreateRequestDto) = {
    val customer = customerRepository.findById(petCreateRequest.ownerId)
    val pet = new Pet()
    pet.name = petCreateRequest.name
    pet.owner = customer.get()
    petRepository.save(pet)
  }

}
