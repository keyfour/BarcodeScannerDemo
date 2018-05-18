package io.github.keyfour13.barcodescannerdemo;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyQRcodeScannerApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Component(modules = {AndroidInjectionModule.class, MyQRcodeScannerAppModule.class})
    public interface MyQRcodeScannerAppComponent extends AndroidInjector<MyQRcodeScannerApp> {}

    @Module
    public abstract class MyQRcodeScannerAppModule {}
}
