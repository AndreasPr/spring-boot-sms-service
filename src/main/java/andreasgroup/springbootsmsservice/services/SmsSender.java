package andreasgroup.springbootsmsservice.services;

import andreasgroup.springbootsmsservice.model.SmsRequest;

/**
 * Created on 04/Dec/2020 to spring-boot-sms-service
 */
public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
