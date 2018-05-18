package io.github.keyfour13.barcodescannerdemo.features.scanner.results.view;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ScanResultsFragmentSubcomponent.class)
public abstract class ScanResultsModule {
    @Binds
    @IntoMap
    @FragmentKey(ScanResultsFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
        bindScanResultsFragmentInjectorFactory(ScanResultsFragmentSubcomponent.Builder builder);
}
