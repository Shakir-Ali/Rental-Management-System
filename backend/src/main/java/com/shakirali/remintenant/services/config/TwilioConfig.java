package com.shakirali.remintenant.services.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@Slf4j
public class TwilioConfig {

    @Value("${twilio.account.sid}")
    private String accountSId;

    @Value("${twilio.auth.token}")
    private String token;

    @PostConstruct
    public void init() {
        Twilio.init(accountSId, token);
    }
}
