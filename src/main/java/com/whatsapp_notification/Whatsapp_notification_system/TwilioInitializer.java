package com.whatsapp_notification.Whatsapp_notification_system;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(TwilioConfigurationProperties.class)
public class TwilioInitializer implements ApplicationRunner {
    private final TwilioConfigurationProperties twilioConfigurationProperties;

    // Standard Constructor

    @override
    public void run(ApplicationArguments args) {
        String accountSid = twilioConfigurationProperties.getAccountSid();
        String authToken = twilioConfigurationProperties.getAuthToken();
        Twilio.init(accountSid, authToken);
    }
}
