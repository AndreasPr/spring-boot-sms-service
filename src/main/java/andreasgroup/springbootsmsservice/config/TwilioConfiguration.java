package andreasgroup.springbootsmsservice.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 04/Dec/2020 to spring-boot-sms-service
 */
@Setter
@Getter
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfiguration {

    private String accountSid;
    private String authToken;
    private String trialNumber;
}
