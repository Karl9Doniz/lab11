package com.example.task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {
    @Getter
    private static MailSender sender;

    public void sendMail(MailInfo info){
        try {
            send(info.generateText());
        } catch (MailjetException | MailjetSocketTimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private void send(String email) throws MailjetException, MailjetSocketTimeoutException {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient("YOUR_API_KEY", "YOUR_API_SECRET", new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "ahitoliev.pn@ucu.edu.ua")
                                        .put("Name", "Andrii"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", "ahitoliev.pn@ucu.edu.ua")
                                                .put("Name", "Andrii")))
                                .put(Emailv31.Message.SUBJECT, "Greetings from Mailjet.")
                                .put(Emailv31.Message.TEXTPART, "My first Mailjet email")
                                .put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
                                .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }

}