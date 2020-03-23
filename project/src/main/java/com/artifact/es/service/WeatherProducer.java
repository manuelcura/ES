/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artifact.es.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherProducer {

    private KafkaTemplate<String, String> simpleProducer;

    public WeatherProducer(KafkaTemplate<String, String> simpleProducer) {
        this.simpleProducer = simpleProducer;
    }

    public void send(String topic, String message) {
        simpleProducer.send("updates", message);
    }
}
