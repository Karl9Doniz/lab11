package com.example.task2;

public class WelcomeCode implements MailCode{
    @Override
    public String generateText(Client client) {
        String template = "Hello, {(NAME})!";
        return template.replaceAll("{{NAME}}", client.getName());
    }
}
