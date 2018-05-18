package io.github.keyfour13.barcodescannerdemo;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MyQRcodeScannerAppModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInhector();
}
