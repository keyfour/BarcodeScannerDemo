package io.github.keyfour13.barcodescannerdemo.scanner;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Singleton
@Component(modules = {ZXScanner.class,ZXScanner.IntentIntegratorModule.class})
public interface Scanner {
    void scan(Activity activity);
}
