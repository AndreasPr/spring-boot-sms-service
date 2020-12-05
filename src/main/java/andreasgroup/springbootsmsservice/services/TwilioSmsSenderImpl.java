package andreasgroup.springbootsmsservice.services;

import andreasgroup.springbootsmsservice.model.SmsRequest;
import andreasgroup.springbootsmsservice.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 04/Dec/2020 to spring-boot-sms-service
 */
@Slf4j
@Service("twilio")
public class TwilioSmsSenderImpl implements SmsSender {

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSenderImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if(isPhoneNumberValid(smsRequest.getPhoneNumber())){
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            log.info("Sent SMS: " + smsRequest);
        }
        else {
            throw new IllegalArgumentException("Phone number: " + smsRequest.getPhoneNumber() + "is not a valid!");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //Validation of phone numbers with format "1234567890"
        if(phoneNumber.matches("\\d{10}")){
            return true;
        }
        //Validation of phone numbers with -, . or spaces e.g. 123-456-7890
        else if(phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")){
            return true;
        }
        //Validation of phone numbers where area code is in braces () e.g. (123)-456-7890
        else if(phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
            return true;
        }
        else {
            return false;
        }
    }
}
