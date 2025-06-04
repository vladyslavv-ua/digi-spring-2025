package io.booking.hotel.service

import io.booking.hotel.dto.request.AddHotelRequest
import io.booking.hotel.dto.response.AddHotelResponse
import io.booking.hotel.dto.response.HotelBaseResponse
import io.booking.hotel.entity.Hotel
import io.booking.hotel.mapper.HotelMapper
import io.booking.hotel.repo.HotelRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service

@Service
class HotelService(
    private val hotelRepository: HotelRepository,
    private val hotelMapper: HotelMapper,
    private val logger: Logger
) {
    fun getById(id: Long): HotelBaseResponse? {
        val hotel = hotelRepository.findHotelsById(id)
        if (hotel == null) {
            // ToDo refactor to rich errors when release
            return null
        }
        return hotelMapper.toHotelBaseResponse(hotel)
    }

    fun getByIdEntity(id: Long): Hotel? {
        return hotelRepository.findHotelsById(id)
    }

    fun getAll(): List<HotelBaseResponse> {
        val hotels = hotelRepository.findAll()
        return hotels.map { hotelMapper.toHotelBaseResponse(it) }
//        return hotelMapper.toHotelBaseResponse(hotels)
    }

    fun add(hotel: AddHotelRequest): AddHotelResponse {
        val mappedHotel = hotelMapper.toHotelFromAddHotelRequest(hotel)
        println(mappedHotel)
        println(hotel)
        val hotelResponse = hotelMapper.toAddHotelResponse(hotelRepository.save(mappedHotel))
        return hotelResponse
    }
}