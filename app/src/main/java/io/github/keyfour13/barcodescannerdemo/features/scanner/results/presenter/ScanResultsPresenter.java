package io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter;


import javax.inject.Inject;

import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsContract;

public class ScanResultsPresenter implements ScanResultsContract.Presenter {

    ScanResultsContract.View view;

    @Inject
    public ScanResultsPresenter() {
    }

    @Override
    public void setView(ScanResultsContract.View view) {
        this.view = view;
    }

    @Override
    public void getResults() {

    }
}
