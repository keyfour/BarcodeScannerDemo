package io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Alex Karpov <keyfour13@gmail.com> 2018
 */
@Singleton
@Component(modules = {ScanResultsPresenterModule.class})
public interface ScanResultsPresenterComponent {
    ScanResultsPresenter providePresenter();
}
