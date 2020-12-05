package andreasgroup.springbootsmsservice.controller;

import andreasgroup.springbootsmsservice.model.SmsRequest;
import andreasgroup.springbootsmsservice.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created on 05/Dec/2020 to spring-boot-sms-service
 */
@RestController
@RequestMapping("api/v1/sms")
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest){
        service.sendSms(smsRequest);
    }
}
