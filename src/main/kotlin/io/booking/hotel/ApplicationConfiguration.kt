package io.booking.hotel

import io.booking.hotel.beans.LoggingBeans
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(LoggingBeans::class)
class ApplicationConfiguration {
}