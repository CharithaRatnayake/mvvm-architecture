package com.jachdev.mvvm.base;

import com.jachdev.mvvm.di.component.ApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        return null;
    }
}
