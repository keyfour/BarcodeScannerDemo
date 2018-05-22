package io.github.keyfour13.barcodescannerdemo.features.scanner.results;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import dagger.multibindings.IntoMap;
import io.github.keyfour13.barcodescannerdemo.R;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter.ScanResultsPresenter;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter.ScanResultsPresenterModule;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragment;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragmentModule;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
public class ScanResultsActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    AndroidInjector<Fragment> fragmentAndroidInjector;

    @Inject
    ScanResultsPresenter scanResultsPresenter;
    @Inject
    ScanResultsFragment scanResultsFragment;

    ScanResultsContract.Presenter presenter;
    ScanResultsContract.View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentAndroidInjector;
    }

    @Module(subcomponents = ScanResultsActivity.DaggerSubcomponent.class)
    public static abstract class DaggerModule {
        @Binds
        @IntoMap
        @ActivityKey(ScanResultsActivity.class)
        abstract AndroidInjector.Factory<? extends Activity>
        bindScanActivityInjectorFactory(ScanResultsActivity.DaggerSubcomponent.Builder builder);
    }

    @Singleton
    @Subcomponent(modules = {ScanResultsPresenterModule.class, ScanResultsFragmentModule.class})
    public interface DaggerSubcomponent extends AndroidInjector<ScanResultsActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<ScanResultsActivity> {}
    }

}
