package io.booking.hotel.dto.response

import io.booking.hotel.entity.Hotel

data class RoomBaseResponse(
    val id: Long,
    var number: String,
    var type: String,
    var pricePerNight: Double,
    val hotel: HotelRoom,
){
    data class HotelRoom(
        val id: Long = 0,
        val name: String,
        val location: String,
        val rating: Int = 0,
    )
}
