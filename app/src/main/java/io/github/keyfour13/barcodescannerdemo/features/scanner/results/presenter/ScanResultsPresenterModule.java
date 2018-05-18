package io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsContract;

@Module
public class ScanResultsPresenterModule {

    @Provides @Singleton
    ScanResultsContract.Presenter providePresenter() {
        return new ScanResultsPresenter();
    }

}
