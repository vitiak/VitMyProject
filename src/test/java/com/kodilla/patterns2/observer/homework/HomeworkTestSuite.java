package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate()  {
        PupilTasks kwasnyTasks = new KwasnyPupilTasks();
        PupilTasks nieKwasnyTasks = new NieKwasnyPupilTasks();
        Mentor michalLangner = new Mentor("Michal Langner");
        Mentor michalLangnerClone = new Mentor("MichalLangnerClone");

        kwasnyTasks.registerObserver(michalLangner);
        nieKwasnyTasks.registerObserver(michalLangnerClone);

        kwasnyTasks.addTask("zadanie 20.3");
        nieKwasnyTasks.addTask("zadanie 24.2.");
        kwasnyTasks.addTask("zadanie 20.4");

        assertEquals(2, michalLangner.getUpdateCount());
        assertEquals(1, michalLangnerClone.getUpdateCount());

    }

}
