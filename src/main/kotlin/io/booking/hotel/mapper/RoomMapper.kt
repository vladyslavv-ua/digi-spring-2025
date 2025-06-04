package io.booking.hotel.mapper

import io.booking.hotel.dto.request.RoomRequestDTO
import io.booking.hotel.dto.response.HotelBaseResponse
import io.booking.hotel.dto.response.RoomBaseResponse
import io.booking.hotel.entity.Hotel
import io.booking.hotel.entity.Room
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants
import org.mapstruct.Mappings

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface RoomMapper {
    fun toRoomRequestDTO(room: Room): RoomRequestDTO

    @Mapping(target = "hotel", ignore = true)
    fun toRoom(roomRequest: RoomRequestDTO): Room
    fun toRoomBaseResponse(room: Room): RoomBaseResponse


    fun toRoomHotel(hotel: Hotel): RoomBaseResponse.HotelRoom


}