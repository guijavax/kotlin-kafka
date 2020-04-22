package com.example.kotlinkafka.controller

import com.example.kotlinkafka.service.KafkaProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/kafka"])
class KafkaController {

    @Autowired
   lateinit var producer: KafkaProducer

    @PostMapping("/publish/{message}")
    fun sendMessageKafka(@PathVariable(value = "message")message : String) {
//        producer.sendMessage(message)
        producer.sendMessageFuncoes(message)
    }
}