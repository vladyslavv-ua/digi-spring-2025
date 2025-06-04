package io.booking.hotel.entity

import jakarta.persistence.*

@Entity
data class Room (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    var hotel: Hotel? = null,

    var number: String,
    var type: String,
    var pricePerNight: Double
)