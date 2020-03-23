/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artifact.es.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ListenerUpdates {

    @Autowired
    private SimpMessagingTemplate template;
    
    @StreamListener(target = "updates")
    public void processMessage(String pushMessage){
        this.template.convertAndSend("/topic/updates", pushMessage);
    }
}