package io.github.keyfour13.barcodescannerdemo.features.scanner.results;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import io.github.keyfour13.barcodescannerdemo.R;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
public class ScanResultsActivity extends AppCompatActivity {

    private ScanResultsContract.View view;
    private ScanResultsContract.Presenter presenter;

    @Inject
    ResultsFeature feature;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        view = feature.fragment;
        presenter = feature.presenter;
        presenter.setView(view);
    }

    @Module(subcomponents = ScanResultsActivity.DaggerSubcomponent.class)
    public static abstract class DaggerModule {
        @Binds
        @IntoMap
        @ActivityKey(ScanResultsActivity.class)
        abstract AndroidInjector.Factory<? extends Activity>
        bindScanActivityInjectorFactory(ScanResultsActivity.DaggerSubcomponent.Builder builder);
    }

    @Subcomponent(modules = {ResultsFeature.DaggerModule.class})
    public interface DaggerSubcomponent extends AndroidInjector<ScanResultsActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<ScanResultsActivity> {}
    }

}
