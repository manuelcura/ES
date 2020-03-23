/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artifact.es.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IBrokerChannel {

    @Input("inbound")
    SubscribableChannel inbound();
    
    @Input("updates")
    SubscribableChannel updates();

}
