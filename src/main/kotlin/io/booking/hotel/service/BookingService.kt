package io.booking.hotel.service

import io.booking.hotel.dto.request.CreateBookingRequest
import io.booking.hotel.dto.response.BookingResponse
import io.booking.hotel.mapper.BookingMapper
import io.booking.hotel.repo.BookingRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service

@Service
class BookingService(
    private val bookingRepository: BookingRepository,
    private val bookingMapper: BookingMapper,
    private val roomService: RoomService,
    private val logger: Logger,
) {
    fun addBooking(request: CreateBookingRequest): BookingResponse? {
        logger.info(request.toString())
        val room = roomService.getRoomByIdEntity(request.roomId)
        if (room == null) {
            return null
        }
        val mapped = bookingMapper.toBookingFromRequest(request)
        mapped.room = room
        bookingRepository.save(mapped)

        logger.info("Booking added for room ${mapped.guestName} ${mapped.room!!.hotel!!.name}")
        val returnBooking = bookingMapper.toCreateBookingResponse(mapped)
        logger.info(returnBooking.toString())
        return returnBooking

    }

    fun getBookingsByName(name: String): List<BookingResponse> {
        val bookings = bookingRepository.findByGuestName(name).filterNotNull().map {
            bookingMapper.toCreateBookingResponse(it)
        }
        return bookings
    }

}