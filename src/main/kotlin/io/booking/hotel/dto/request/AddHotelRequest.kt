package io.booking.hotel.dto.request

data class AddHotelRequest(
    val name: String,
    val location: String,
    val rating: Int,
)
