package com.robert.objectboxdemo;

import android.app.Application;

import com.robert.objectboxdemo.bean.MyObjectBox;

import io.objectbox.BoxStore;

/**
 * @author: robert
 * @date: 2017-11-22
 * @time: 16:47
 * @说明:
 */
public class App extends Application {
    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(App.this).build();
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
