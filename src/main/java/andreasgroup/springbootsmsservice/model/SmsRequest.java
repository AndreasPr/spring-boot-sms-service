package andreasgroup.springbootsmsservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created on 04/Dec/2020 to spring-boot-sms-service
 */
@Data
@AllArgsConstructor
public class SmsRequest {

    @NotBlank
    @JsonProperty("phoneNumber")
    private final String phoneNumber;

    @NotBlank
    @JsonProperty("message")
    private final String message;
}
