package io.github.keyfour13.barcodescannerdemo.features.scanner.results.view;


import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {})
public interface ScanResultsFragmentSubcomponent extends AndroidInjector<ScanResultsFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<ScanResultsFragment> {}
}
