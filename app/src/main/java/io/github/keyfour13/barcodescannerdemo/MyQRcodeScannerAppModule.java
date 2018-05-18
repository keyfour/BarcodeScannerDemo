package io.github.keyfour13.barcodescannerdemo;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.github.keyfour13.barcodescannerdemo.features.main.MainActivity;

@Module
public abstract class MyQRcodeScannerAppModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInhector();
}
