package com.whatsapp_notification.Whatsapp_notification_system;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppMessageDispatcher {
    private final TwilioConfigurationProperties twilioConfigurationProperties;

    public WhatsAppMessageDispatcher(TwilioConfigurationProperties twilioConfigurationProperties) {
        this.twilioConfigurationProperties = twilioConfigurationProperties;
    }
    // Sending template messages
    public void dispatchNewArticleNotification(String phoneNumber, String articleUrl) {
        String messagingSid = twilioConfigurationProperties.getMessagingSid();
        String contentSid = twilioConfigurationProperties.getNewArticleNotification().getContentSid();
        PhoneNumber toPhoneNumber = new PhoneNumber(String.format("whatsapp:%s", phoneNumber));

        JSONObject contentVariables = new JSONObject();
        contentVariables.put("ArticleURL", articleUrl);

        Message.creator(toPhoneNumber, messagingSid)
                .setContentSid(contentSid)
                .setContentVariables(contentVariables.toString())
                .create();
    }
    // Sending free flow messages
    public void dispatchReplyMessage(String phoneNumber, String username) {
        String messagingSid = twilioConfigurationProperties.getMessagingSid();
        PhoneNumber toPhoneNumber = new PhoneNumber(String.format("whatsapp:%s", phoneNumber));

        String message = String.format("Hey %s, our team will get back to you shortly.", username);
        Message.creator(toPhoneNumber, messagingSid, message).create();
    }
}
