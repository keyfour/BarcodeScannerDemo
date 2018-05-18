package io.github.keyfour13.barcodescannerdemo.features.scanner;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragmentModule;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Subcomponent(modules = {ScanResultsFragmentModule.class})
public interface ScanActivitySubcomponent extends AndroidInjector<ScanActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ScanActivity> {}
}
