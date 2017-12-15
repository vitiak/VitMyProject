package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        Context contex = new Context();
        contex.setVariable("message", message);
        contex.setVariable("tasks_url", "http://localhost:8888/crud");
        contex.setVariable("button", "Visit website");
        contex.setVariable("admin_name", adminConfig.getAdminName());
        contex.setVariable("by_message", "regards, machine");
        contex.setVariable("company_details", adminConfig.getCompanyName());
        return templateEngine.process("mail/created-trello-card-mail", contex);
    }

}
