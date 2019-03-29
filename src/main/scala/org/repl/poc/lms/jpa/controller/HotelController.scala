package org.repl.poc.lms.jpa.controller

import java.lang.Long

import javax.validation.Valid
import org.repl.poc.lms.jpa.model.Hotel
import org.repl.poc.lms.jpa.repository.HotelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.ui.Model
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(value = Array("/api"))
class HotelController @Autowired()(private val hotelRepository: HotelRepository) {

  @RequestMapping(value = Array("/v1/hotels"), method = Array(RequestMethod.GET))
  @ResponseBody
  def list(model: Model) = {
    hotelRepository.findAll()
  }

  @RequestMapping(value = Array("/v1/hotels/{id}"), method = Array(RequestMethod.GET))
  @ResponseBody
  def edit(@PathVariable("id") id: Long) = {
    hotelRepository.findById(id)
  }

  @PostMapping(value = Array("/v1/hotels"), consumes = Array(MediaType.APPLICATION_JSON_VALUE), produces = Array(MediaType.APPLICATION_JSON_VALUE))
  @ResponseBody
  def create(@Valid @RequestBody hotel: Hotel) =
    hotelRepository.save(hotel)
}