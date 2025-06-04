package io.booking.hotel.repo;

import io.booking.hotel.entity.Booking
import org.springframework.data.jpa.repository.JpaRepository

interface BookingRepository : JpaRepository<Booking, Long> {
    fun findByGuestName(guestName: String?): MutableList<Booking?>
}