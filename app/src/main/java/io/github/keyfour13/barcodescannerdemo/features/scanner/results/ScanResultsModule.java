/*
 * Copyright (c) Alexander Karpov 2018.
 */

package io.github.keyfour13.barcodescannerdemo.features.scanner.results;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.github.keyfour13.barcodescannerdemo.di.ActivityScoped;
import io.github.keyfour13.barcodescannerdemo.di.FragmentScoped;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter.ScanResultsPresenter;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragment;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Module
public class ScanResultsModule {
    @Module
    public abstract class StatisticsModule {

        @FragmentScoped
        @ContributesAndroidInjector
        abstract ScanResultsFragment scanResultsFragment();

        @ActivityScoped
        @Binds
        abstract ScanResultsContract.Presenter scanResultsPresenter(ScanResultsPresenter presenter);
    }
}
