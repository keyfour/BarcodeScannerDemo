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
import io.github.keyfour13.barcodescannerdemo.features.main.MainActivityModule;
import io.github.keyfour13.barcodescannerdemo.features.scanner.ScanActivityModule;

public class MyQRcodeScannerApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMyQRcodeScannerApp_MyQRcodeScannerAppComponent.create()
        .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    @Component(modules = {AndroidInjectionModule.class, MyQRcodeScannerAppModule.class,
            MainActivityModule.class, ScanActivityModule.class})
    public interface MyQRcodeScannerAppComponent extends AndroidInjector<MyQRcodeScannerApp> {}

    @Module
    public abstract class MyQRcodeScannerAppModule {}
}
