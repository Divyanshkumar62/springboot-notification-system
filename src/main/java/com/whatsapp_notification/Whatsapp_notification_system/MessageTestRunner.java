package com.whatsapp_notification.Whatsapp_notification_system;

import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageTestRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // This code runs *after* your TwilioInitializer,
        // so the Twilio client is already set up.

        // --- CONFIGURE YOUR TEST HERE ---

        // 1. SET YOUR PHONE NUMBER
        //    Must be the number you joined the sandbox with (e.g., "whatsapp:+91...")
        String YOUR_PHONE_NUMBER = "whatsapp:+916207985651";

        // 2. THIS IS THE SANDBOX SENDER NUMBER
        String TWILIO_SANDBOX_NUMBER = "whatsapp:+14155238886";

        // 3. THIS IS THE SANDBOX TEMPLATE
        //    Go to "Messaging > Try it out > Send a WhatsApp message"
        //    to see your allowed templates.
        //    Common ones are:
        //    - "Your {{1}} code is {{2}}"
        //    - "Your appointment is coming up on {{1}} at {{2}}"
        //
        //    Let's use the code template:
        String SANDBOX_TEMPLATE_BODY = "Your verification code is 876543";

        // --- END OF CONFIGURATION ---


        try {
            Message message = Message.creator(
                    new PhoneNumber(YOUR_PHONE_NUMBER),
                    new PhoneNumber(TWILIO_SANDBOX_NUMBER),
                    SANDBOX_TEMPLATE_BODY
            ).create();

            System.out.println("--- TEST MESSAGE SENT! ---");
            System.out.println("SID: " + message.getSid());
            System.out.println("Status: " + message.getStatus());
            System.out.println("--------------------------");

        } catch (Exception e) {
            System.err.println("!!! ERROR SENDING TEST MESSAGE !!!");
            System.err.println(e.getMessage());
        }
    }
}