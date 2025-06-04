package io.booking.hotel.dto.request

import java.time.LocalDate

data class CreateBookingRequest(
    val roomId: Long,
    val guestName: String,
    val fromDate: LocalDate,
    val toDate: LocalDate,
)
