package io.booking.hotel.dto.response

import java.time.LocalDate

data class BookingResponse(
    val id: Long,
    val room: RoomBaseResponse,
    val guestName: String,
    val fromDate: LocalDate,
    val toDate: LocalDate,
)
