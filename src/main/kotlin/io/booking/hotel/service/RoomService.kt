package io.booking.hotel.service

import io.booking.hotel.dto.request.RoomRequestDTO
import io.booking.hotel.dto.response.RoomBaseResponse
import io.booking.hotel.entity.Room
import io.booking.hotel.mapper.RoomMapper
import io.booking.hotel.repo.HotelRepository
import io.booking.hotel.repo.RoomRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service

@Service
class RoomService(
    private val roomRepository: RoomRepository,
    private val roomMapper: RoomMapper,
    private val hotelService: HotelService,
    private val logger: Logger,
) {
    fun findByHotelId(id: Long): List<RoomBaseResponse> {
        val rooms = roomRepository.findByHotelId(id)
        return rooms.map { roomMapper.toRoomBaseResponse(it) }
    }
    fun save(room: RoomRequestDTO): RoomBaseResponse? {
        logger.info(room.toString())
        val hotel = hotelService.getByIdEntity(room.hotelId)
        if (hotel == null) {
            // ToDo refactor to rich errors when release
            return null
        }

        val mappedRoom = roomMapper.toRoom(room)
        mappedRoom.hotel = hotel

        return roomMapper.toRoomBaseResponse(roomRepository.save(mappedRoom))
    }

    fun getRoomByIdEntity(roomId: Long): Room? {
        return roomRepository.findById(roomId).orElse(null)
    }


}