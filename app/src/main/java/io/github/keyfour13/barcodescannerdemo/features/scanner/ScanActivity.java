/*
 * Copyright (c) Alexander Karpov 2018.
 */

package io.github.keyfour13.barcodescannerdemo.features.scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import io.github.keyfour13.barcodescannerdemo.R;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsActivity;
import io.github.keyfour13.barcodescannerdemo.scanner.ZXScanner;

public class ScanActivity extends AppCompatActivity {

    @Inject
    ZXScanner scanner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        scanner.scan(this);
    }

    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            Intent intent = new Intent(this, ScanResultsActivity.class);
            startActivity(intent);
        }
    }

    @Module(subcomponents = ScanActivity.DaggerSubcomponent.class)
    public static abstract class DaggerModule {
        @Binds
        @IntoMap
        @ActivityKey(ScanActivity.class)
        abstract AndroidInjector.Factory<? extends Activity>
        bindScanActivityInjectorFactory(ScanActivity.DaggerSubcomponent.Builder builder);
    }

    @Subcomponent(modules = {})
    public interface DaggerSubcomponent extends AndroidInjector<ScanActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<ScanActivity> {}
    }

}
