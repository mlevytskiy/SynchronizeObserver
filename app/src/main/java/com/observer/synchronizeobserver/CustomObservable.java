package com.observer.synchronizeobserver;

import java.util.Vector;

/**
 * Created by max on 29.03.16.
 */
public class CustomObservable {

    private Vector<CustomObserver> observers = new Vector<>();

    public void addObserver(CustomObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(CustomObserver observer) {
        observers.remove(observer);
    }

    public synchronized void notifyObservers() {
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
