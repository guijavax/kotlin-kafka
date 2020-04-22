package com.example.kotlinkafka.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer {
    companion object {
        internal val LOGGER  = LoggerFactory.getLogger(KafkaProducer::class.java)
        internal val TOPIC = "users"
        internal val OTHERTOPIC = "funcoes"
    }

    @Autowired
    lateinit var template : KafkaTemplate<String, String>

    fun sendMessage(message : String) {
        LOGGER.info("Producing message: $message")
        this.template.send(TOPIC, message)
    }

    fun sendMessageFuncoes(message : String) {
        LOGGER.info("Producing message: $message")
        this.template.send(OTHERTOPIC, message)
    }
}