/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artifact.es.configs;

import com.artifact.es.kafka.IBrokerChannel;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(IBrokerChannel.class)
public class KafkaConfig {

}
