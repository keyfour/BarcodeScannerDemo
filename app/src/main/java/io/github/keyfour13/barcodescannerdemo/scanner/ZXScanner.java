package io.github.keyfour13.barcodescannerdemo.scanner;

import android.app.Activity;

import com.google.zxing.integration.android.IntentIntegrator;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Module
public class ZXScanner {

    @Inject
    @Singleton
    public void scan(Activity activity) {
        IntentIntegratorModule.provideIntegrator(activity).initiateScan();
    }

    @Module
    public static class IntentIntegratorModule {
        @Provides
        @Singleton static IntentIntegrator provideIntegrator(Activity activity) {
            return new IntentIntegrator(activity);
        }
    }

}
