package com.example.api.kafka.service

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Consumer {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(Consumer::class.java)
        private const val TOPIC = "users"
        private const val OTHETOPIC = "funcoes"
    }

    @KafkaListener(topics = [TOPIC], groupId = "group_id")
    fun consumerUsers(message : String) {
        LOGGER.info("Consumed message: $message")
    }

    @KafkaListener(topics = [OTHETOPIC], groupId = "group_id")
    fun consumerFuncoes(message: String) {
        message.split(",").forEach{item ->
            LOGGER.info("A função é: $item")
        }
    }
}