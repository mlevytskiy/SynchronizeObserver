package com.observer.synchronizeobserver;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by max on 29.03.16.
 */
public class CustomObservable2 {

    private CopyOnWriteArraySet<CustomObserver> observers = new CopyOnWriteArraySet<>();

    public void addObserver(CustomObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CustomObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (CustomObserver observer : observers) {
            observer.receive(null);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
