package io.booking.hotel.controller

import io.booking.hotel.dto.request.RoomRequestDTO
import io.booking.hotel.dto.response.RoomBaseResponse
import io.booking.hotel.entity.Hotel
import io.booking.hotel.entity.Room
import io.booking.hotel.service.HotelService
import io.booking.hotel.service.RoomService
import org.slf4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/rooms")
class RoomController(
    private val roomService: RoomService,
    private val hotelService: HotelService,
    private val logger: Logger
) {

    @GetMapping("/by-hotel/{hotelId}")
    fun getRoomsByHotel(@PathVariable hotelId: Long): ResponseEntity<List<RoomBaseResponse>> {
        return ResponseEntity.ok(roomService.findByHotelId(hotelId))
    }

    @PostMapping
    fun addRoom(@RequestBody roomRequest: RoomRequestDTO): ResponseEntity<out Any> {
        logger.info("Add room: {}", roomRequest)
        val hotel = hotelService.getById(roomRequest.hotelId)
        if (hotel == null) {
            return ResponseEntity.badRequest().body("Hotel not found")
        }

        return ResponseEntity.ok(roomService.save(roomRequest))
    }
}