package io.github.keyfour13.barcodescannerdemo.features.scanner.results;

import android.app.Fragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ScanResultsModule.class})
public interface ScanResultsComponent {

    ScanResultsContract.Presenter providePresenter();

}
