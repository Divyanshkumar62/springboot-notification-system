package com.whatsapp_notification.Whatsapp_notification_system;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // Sets a base path for all methods in this controller
public class WhatsAppReplyController {

    private final WhatsAppMessageDispatcher whatsappMessageDispatcher;

    // Inject your service
    public WhatsAppReplyController(WhatsAppMessageDispatcher whatsappMessageDispatcher) {
        this.whatsappMessageDispatcher = whatsappMessageDispatcher;
    }

    @PostMapping(value = "/whatsapp-message-reply")
    public ResponseEntity<Void> reply(@RequestParam("ProfileName") String username,
                                      @RequestParam("WaId") String phoneNumber) {

        // Call the new method you just created
        whatsappMessageDispatcher.dispatchReplyMessage(phoneNumber, username);

        // Send a 200 OK response back to Twilio
        return ResponseEntity.ok().build();
    }
}