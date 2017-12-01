package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PupilTasks  implements Observable {
    private final List<Observer> mentors;
    private final ArrayDeque<String> tasks;
    private final String name;

    public PupilTasks(String name) {
        mentors = new ArrayList<>();
        tasks = new ArrayDeque<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.offer(task);
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        mentors.add(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : mentors) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        mentors.remove(observer);
    }

    public String getName() {
        return name;
    }

    public ArrayDeque<String> getTasks() {
        return tasks;
    }
}
