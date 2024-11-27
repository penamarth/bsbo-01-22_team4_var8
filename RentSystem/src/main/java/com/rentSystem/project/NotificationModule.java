package com.rentSystem.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationModule implements Notifier {

    private final Map<String, List<Observer>> observers = new HashMap<>();

    @Override
    public void subscribe(Observer observer, String notificationType) {
        observers.computeIfAbsent(notificationType, k -> new ArrayList<>()).add(observer);
        System.out.println("Observer subscribed to " + notificationType);
    }

    @Override
    public void unsubscribe(Observer observer, String notificationType) {
        List<Observer> userObservers = observers.get(notificationType);
        if (userObservers != null) {
            userObservers.remove(observer);
            System.out.println("Observer unsubscribed from " + notificationType);
        }
    }

    @Override
    public void notifyObservers(Notification notification) {
        List<Observer> userObservers = observers.get(notification.getNotificationType());
        if (userObservers != null) {
            for (Observer observer : userObservers) {
                observer.update(notification);
            }
        }
    }
}
