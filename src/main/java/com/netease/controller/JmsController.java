package com.netease.controller;

import com.netease.service.ProducerServiceImpl;
import com.netease.service.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jms.Destination;

/**
 * Created by hz-lpf on 16-5-25.
 */
@Controller
@RequestMapping("/jms")
public class JmsController {

    ProducerServiceImpl producerService;
    Destination destination;
    RedisServiceImpl redisService;

    @RequestMapping("/send")
    public String toSend() {
        return "sendPage";
    }

    @RequestMapping("/sended")
    public String send(ModelMap modelMap,@RequestParam String msg) {
        producerService.sendMsg(destination,msg);
        redisService.add("now",msg);
        return "done";
    }

    @Autowired
    @Qualifier("producerService")
    public void setProducerService(ProducerServiceImpl producerService) {
        this.producerService = producerService;
    }

    @Autowired
    @Qualifier("queueDestination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Autowired
    @Qualifier("redisService")
    public void setRedisService(RedisServiceImpl redisService) {
        this.redisService = redisService;
    }

}
