package io.booking.hotel.controller

import io.booking.hotel.dto.request.AddHotelRequest
import io.booking.hotel.dto.response.AddHotelResponse
import io.booking.hotel.dto.response.HotelBaseResponse
import io.booking.hotel.entity.Hotel
import io.booking.hotel.repo.HotelRepository
import io.booking.hotel.service.HotelService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional


@RestController
@RequestMapping("/hotels")
class HotelController(private val hotelService: HotelService) {

    @GetMapping
    fun getHotels(): ResponseEntity<List<HotelBaseResponse>> {
        return ResponseEntity.ok(hotelService.getAll())
    }

    @GetMapping("/{id}")
    fun getHotelById(@PathVariable id: Long): ResponseEntity<out HotelBaseResponse> {
        val hotel = hotelService.getById(id)
        if (hotel == null) {
            return ResponseEntity.notFound().build<HotelBaseResponse>()
        }
        return ResponseEntity.ok(hotel)
    }

    @PostMapping
    fun addHotel(@RequestBody hotel: AddHotelRequest): ResponseEntity<AddHotelResponse> {
        return ResponseEntity.ok(hotelService.add(hotel))
    }
}