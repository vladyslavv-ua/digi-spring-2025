package io.booking.hotel.repo;

import io.booking.hotel.entity.Hotel
import org.springframework.data.jpa.repository.JpaRepository;

interface HotelRepository : JpaRepository<Hotel, Long>{
    fun findHotelsById(id: Long): Hotel?
}