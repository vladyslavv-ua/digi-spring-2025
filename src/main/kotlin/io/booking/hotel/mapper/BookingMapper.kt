package io.booking.hotel.mapper

import io.booking.hotel.dto.request.CreateBookingRequest
import io.booking.hotel.dto.response.BookingResponse
import io.booking.hotel.entity.Booking
import io.booking.hotel.entity.Room
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface BookingMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "room", ignore = true)
    fun toBookingFromRequest(request: CreateBookingRequest): Booking


    @Mapping(target = "room", source = "room")
    fun toBookingEntity(request: CreateBookingRequest, room: Room): Booking

    fun toCreateBookingResponse(booking: Booking): BookingResponse
}