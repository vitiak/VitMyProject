package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks.");
        functionality.add("Provides connection with trello account");
        functionality.add("Application allows sending tasks to Trello.");

        Context contex = new Context();
        contex.setVariable("message", message);
        contex.setVariable("tasks_url", "http://localhost:8888/crud");
        contex.setVariable("button", "Visit website");
//        contex.setVariable("admin_name", adminConfig.getAdminName());
        contex.setVariable("by_message", "regards, machine");
//        contex.setVariable("company_details", adminConfig.getCompanyName());
        contex.setVariable("show_button", false);
        contex.setVariable("is_friend", false);
        contex.setVariable("admin_config", adminConfig);
        contex.setVariable("application_functionality", functionality);

        return templateEngine.process("mail/created-trello-card-mail", contex);
    }

    public String buildEmailCountOfTasks(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks.");
        functionality.add("Provides connection with trello account");
        functionality.add("Application allows sending tasks to Trello.");

        Context contex = new Context();
        contex.setVariable("message", message);
        contex.setVariable("tasks_url", "http://vitiak.github.io");
        contex.setVariable("button", "Visit website");
        contex.setVariable("by_message", "best regards, \nmachine");
        contex.setVariable("show_button", true);
        contex.setVariable("is_friend", false);
        contex.setVariable("admin_config", adminConfig);
        contex.setVariable("application_functionality", functionality);

        return templateEngine.process("mail/created-trello-card-mail", contex);
    }


}
