package com.jachdev.mvvm.di.component;

import android.app.Application;

import com.jachdev.mvvm.base.BaseApplication;
import com.jachdev.mvvm.di.module.ActivityBindingModule;
import com.jachdev.mvvm.di.module.ApplicationModule;
import com.jachdev.mvvm.di.module.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}
