package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {
//    private String mailFrom;
    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

    public Mail(String mailTo, String subject, String message/*, String mailFrom*/) {
        this.mailTo = mailTo;
  //      this.mailFrom = mailFrom;
        this.subject = subject;
        this.message = message;
    }
}
