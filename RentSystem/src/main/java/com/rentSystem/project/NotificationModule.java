package com.rentSystem.project;
import java.util.ArrayList;
import java.util.List;

public class NotificationModule implements Notifier {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println("Observer subscribed: " + observer.getClass().getSimpleName());
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer unsubscribed: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers(Notification notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }
}
