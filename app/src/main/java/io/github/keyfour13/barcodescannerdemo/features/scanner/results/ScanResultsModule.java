package io.github.keyfour13.barcodescannerdemo.features.scanner.results;

import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragment;

@Module
public class ScanResultsModule {

    @Provides
    ScanResultsContract.View provideView() {
        return ScanResultsFragment.newInstance();
    }

    @Provides @Singleton
    ScanResultsContract.Presenter providePresenter() {
        return new ScanResultsPresenter(ScanResultsFragment.newInstance());
    }

    @Provides
    Fragment provideFragment() {
        return ScanResultsFragment.newInstance();
    }

}
