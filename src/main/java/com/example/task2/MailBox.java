package com.example.task2;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private final List<MailInfo> infos;
    private final MailSender sender;

    public MailBox() {
        infos = new ArrayList<>();
        sender = MailSender.getSender();
    }

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }

    public void sendAll() {
        for (MailInfo info: infos) {
            info.generateText();
            sender.sendMail(info);
        }
    }

}