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

    // standard setters and getters
    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getMessagingSid() {
        return messagingSid;
    }

    public void setMessagingSid(String messagingSid) {
        this.messagingSid = messagingSid;
    }

    @Valid
    private NewArticleNotification newArticleNotification = newArticleNotification();

    class NewArticleNotification {

        @NotBlank
        @Pattern(regexp = "^HX[0-9a-fA-F]{32}$")
        private String contentSid;

        // Standard Getter and Setter
        public String getContentSid() {
            return contentSid;
        }

        public void setContentSid(String contentSid) {
            this.contentSid = contentSid;
        }
    }
}
