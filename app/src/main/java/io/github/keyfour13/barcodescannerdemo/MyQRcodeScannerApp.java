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
import dagger.android.support.AndroidSupportInjectionModule;
import io.github.keyfour13.barcodescannerdemo.features.main.MainActivity;
import io.github.keyfour13.barcodescannerdemo.features.scanner.ScanActivity;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsActivity;

public class MyQRcodeScannerApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMyQRcodeScannerApp_DaggerComponent.create().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    @Component(modules = {AndroidSupportInjectionModule.class, DaggerModule.class,
            MainActivity.DaggerModule.class, ScanActivity.DaggerModule.class,
            ScanResultsActivity.DaggerModule.class})
    public interface DaggerComponent extends AndroidInjector<MyQRcodeScannerApp> {}

    @Module
    public static abstract class DaggerModule {}
}
