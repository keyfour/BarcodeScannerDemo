package io.github.keyfour13.barcodescannerdemo.scanner;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Singleton
@Component(modules = {ScannerModule.class,ZXScanner.IntentIntegratorModule.class})
public interface ScannerComponent {
    Scanner scanner();
}
