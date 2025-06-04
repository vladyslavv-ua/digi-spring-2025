package io.booking.hotel.dto.response

import io.booking.hotel.entity.Hotel

data class HotelBaseResponse(
    val id: Long = 0,
    val name: String,
    val location: String,
    val rating: Int = 0,
    val rooms: List<HotelRoom>? = emptyList()
) {
    data class HotelRoom(
        val id: Long,
        var number: String,
        var type: String,
        var pricePerNight: Double,
    )
}
