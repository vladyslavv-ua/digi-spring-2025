package io.booking.hotel.dto.response

data class AddHotelResponse(
    val id: Long,
    val name: String,
    val location: String,
    val rating: Int,
)
