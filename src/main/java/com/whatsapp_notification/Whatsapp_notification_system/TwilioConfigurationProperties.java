package com.whatsapp_notification.Whatsapp_notification_system;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "com.divyansh.twilio")
public class TwilioConfigurationProperties {
    @NotBlank
    @Pattern(regexp = "^AC[0-9a-fA-F]{32}$")
    private String accountSid;

    @NotBlank
    private String authToken;

    @NotBlank
    @Pattern(regexp = "^MG[0-9a-fA-F]{32}$")
    private String messagingSid;

    public String getMessagingSid() {
        return messagingSid;
    }

    public void setMessagingSid(String messagingSid) {
        this.messagingSid = messagingSid;
    }

    // standard setters and getters
}
