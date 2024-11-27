package com.rentSystem.project;
import java.util.*;

public interface Notifier {
    void subscribe(Observer observer, String notificationType);
    void unsubscribe(Observer observer, String notificationType);
    void notifyObservers(Notification notification);
}
