package com.whatsapp_notification.Whatsapp_notification_system;

// Import statements for validation
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "com.divyansh.twilio") // Make sure this matches your application.yaml
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

    // --- FIXES ARE HERE ---

    @Valid // 1. Was @valid (lowercase)
    private NewArticleNotification newArticleNotification = new NewArticleNotification(); // 2. Was new newArticleNotification()

    // 3. ADDED getter for the nested object
    public NewArticleNotification getNewArticleNotification() {
        return newArticleNotification;
    }

    // 4. ADDED setter for the nested object
    public void setNewArticleNotification(NewArticleNotification newArticleNotification) {
        this.newArticleNotification = newArticleNotification;
    }
    // --- END OF FIXES ---


    // This inner class is correct as you had it
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