package io.booking.hotel.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class RoomRequestDTO(
    @JsonProperty("hotel_id")
    val hotelId: Long,
    val number:String,
    val type: String,
    val pricePerNight: Double,
)
