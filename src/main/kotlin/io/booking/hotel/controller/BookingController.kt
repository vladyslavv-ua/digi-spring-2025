package io.booking.hotel.controller;

import io.booking.hotel.dto.request.CreateBookingRequest
import io.booking.hotel.dto.response.BookingResponse
import io.booking.hotel.entity.Booking
import io.booking.hotel.service.BookingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bookings")
class BookingController(private val bookingService: BookingService) {

    @PostMapping
    fun createBooking(@RequestBody booking: CreateBookingRequest): ResponseEntity<BookingResponse> {
        val booking = bookingService.addBooking(booking)
        if (booking == null) {
            return ResponseEntity.notFound().build<BookingResponse>()
        }

        return ResponseEntity.ok(booking)
    }

    @GetMapping("/by-guest")
    fun getBookingsByGuest(@RequestParam guestName: String): ResponseEntity<List<BookingResponse>> {
        val bookings = bookingService.getBookingsByName(guestName)
        return ResponseEntity.ok(bookings)
    }
}