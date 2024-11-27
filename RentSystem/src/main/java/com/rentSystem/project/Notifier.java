package com.rentSystem.project;
import java.util.*;

public interface Notifier {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(Notification notification);
}
