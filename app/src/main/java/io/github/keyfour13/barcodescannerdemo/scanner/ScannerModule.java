package io.github.keyfour13.barcodescannerdemo.scanner;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Module
public class ScannerModule {

    @Provides
    @Singleton
    static Scanner provideScanner() {
        return new ZXScanner();
    }

}
