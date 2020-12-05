package andreasgroup.springbootsmsservice.services;

import andreasgroup.springbootsmsservice.model.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created on 05/Dec/2020 to spring-boot-sms-service
 */
@org.springframework.stereotype.Service
public class Service {
    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSenderImpl smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
