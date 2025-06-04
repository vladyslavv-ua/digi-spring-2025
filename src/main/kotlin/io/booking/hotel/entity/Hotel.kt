package io.booking.hotel.entity

import jakarta.persistence.*


@Entity
data class Hotel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val location: String,
    val rating: Int = 0,

    @OneToMany(mappedBy = "hotel", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val rooms: List<Room>?
)