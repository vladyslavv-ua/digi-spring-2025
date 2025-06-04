package io.booking.hotel.beans

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.BeanRegistrarDsl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans

@Configuration
class LoggingBeans {
    @Bean
    fun logger() =
        LoggerFactory.getLogger("ApplicationLogger")

}

