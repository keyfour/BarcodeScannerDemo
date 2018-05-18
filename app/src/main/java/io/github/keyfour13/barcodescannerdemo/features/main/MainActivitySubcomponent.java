package io.github.keyfour13.barcodescannerdemo.features.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;


@Subcomponent(modules = {})
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
