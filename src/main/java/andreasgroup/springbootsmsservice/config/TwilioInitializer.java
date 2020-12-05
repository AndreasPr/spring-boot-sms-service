package andreasgroup.springbootsmsservice.config;

import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 04/Dec/2020 to spring-boot-sms-service
 */
@Slf4j
@Configuration
public class TwilioInitializer {

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
        log.info("Twilio initialized with account sid: {}", twilioConfiguration.getAccountSid());
    }
}
