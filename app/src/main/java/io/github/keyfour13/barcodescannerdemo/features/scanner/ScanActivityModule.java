package io.github.keyfour13.barcodescannerdemo.features.scanner;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Module(subcomponents = ScanActivitySubcomponent.class)
public abstract class ScanActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(ScanActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
        bindScanActivityInjectorFactory(ScanActivitySubcomponent.Builder builder);
}
