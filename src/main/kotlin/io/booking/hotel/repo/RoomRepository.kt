package io.booking.hotel.repo;

import io.booking.hotel.entity.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository : JpaRepository<Room, Long> {
    fun findByHotelId(hotelId: Long): List<Room>
}