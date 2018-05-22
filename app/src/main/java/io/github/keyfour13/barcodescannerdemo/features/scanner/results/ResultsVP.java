/*
 * Copyright (c) Alexander Karpov 2018.
 */

package io.github.keyfour13.barcodescannerdemo.features.scanner.results;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter.ScanResultsPresenter;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter.ScanResultsPresenterModule;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragment;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragmentModule;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
public class ResultsVP {

    @Inject
    ScanResultsPresenter presenter;

    @Inject
    ScanResultsFragment fragment;

    @Inject
    public ResultsVP() {}

    @Module
    public static class DaggerModule {
        @Provides @Singleton
        static ResultsVP provideResultsFeature() {
            return new ResultsVP();
        }
    }

    @Singleton
    @Component(modules = {ResultsVP.DaggerModule.class,
            ScanResultsPresenterModule.class, ScanResultsFragmentModule.class})
    public interface DaggerComponent {
        ResultsVP provodeResultsFeature();
    }

}
