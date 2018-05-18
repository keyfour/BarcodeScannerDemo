package io.github.keyfour13.barcodescannerdemo;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import io.github.keyfour13.barcodescannerdemo.features.main.MainActivityModule;

@Component(modules = {AndroidInjectionModule.class, MyQRcodeScannerAppModule.class,
        MainActivityModule.class})
public interface MyQRcodeScannerAppComponent extends AndroidInjector<MyQRcodeScannerApp> {

}
