package com.observer.synchronizeobserver;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CustomObservable2 observable = new CustomObservable2();
        addObserver(observable);
        addObserver(observable);
        addObserver(observable);
        final CustomObserver customObserver = addObserver(observable);

        new Thread(new Runnable() {
            @Override
            public void run() {
                observable.notifyObservers();

            }
        }).start();

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                observable.removeObserver(customObserver);
            }
        });
    }

    private CustomObserver addObserver(CustomObservable2 observable) {
        CustomObserver customObserver = new CustomObserver() {
            @Override
            public void receive(String message) {

            }
        };
        observable.addObserver(customObserver);
        return customObserver;
    }
}
