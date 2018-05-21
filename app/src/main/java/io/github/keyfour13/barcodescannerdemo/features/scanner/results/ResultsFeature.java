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
public class ResultsFeature {

    @Inject
    ScanResultsPresenter presenter;

    @Inject
    ScanResultsFragment fragment;

    @Inject
    public ResultsFeature() {}

    @Module
    public static class DaggerModule {
        @Provides @Singleton
        static ResultsFeature provideResultsFeature() {
            return new ResultsFeature();
        }
    }

    @Singleton
    @Component(modules = {ResultsFeature.DaggerModule.class,
            ScanResultsPresenterModule.class, ScanResultsFragmentModule.class})
    public interface DaggerComponent {
        ResultsFeature provodeResultsFeature();
    }

}
