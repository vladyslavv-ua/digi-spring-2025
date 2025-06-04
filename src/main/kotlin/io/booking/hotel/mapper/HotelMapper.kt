package io.booking.hotel.mapper

import io.booking.hotel.dto.request.AddHotelRequest
import io.booking.hotel.dto.response.AddHotelResponse
import io.booking.hotel.dto.response.HotelBaseResponse
import io.booking.hotel.entity.Hotel
import io.booking.hotel.entity.Room
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface HotelMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rooms", ignore = true)
    fun toHotelFromAddHotelRequest(hotelRequest: AddHotelRequest): Hotel

    fun toAddHotelResponse(hotel: Hotel): AddHotelResponse

    fun toHotelBaseResponse(hotel: Hotel): HotelBaseResponse

    fun toHotelRoom(room: Room): HotelBaseResponse.HotelRoom

}