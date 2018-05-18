package io.github.keyfour13.barcodescannerdemo;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {AndroidInjectionModule.class, MyQRcodeScannerAppModule.class})
public interface MyQRcodeScannerAppComponent extends AndroidInjector<MyQRcodeScannerApp> {

}
