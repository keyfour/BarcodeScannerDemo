package io.github.keyfour13.barcodescannerdemo.features.scanner.results;


import javax.inject.Inject;

public class ScanResultsPresenter implements ScanResultsContract.Presenter {

    private ScanResultsContract.View view;

    @Inject
    public ScanResultsPresenter(ScanResultsContract.View view) {
        this.view = view;
    }

    @Override
    public void setView(ScanResultsContract.View view) {
        this.view = view;
    }

    @Override
    public void getResults() {

    }
}
