package io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter;


import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import io.github.keyfour13.barcodescannerdemo.features.scanner.ScanActivity;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsContract;

public class ScanResultsPresenter implements ScanResultsContract.Presenter {

    private ScanResultsContract.View view;

    @Inject
    public ScanResultsPresenter() {
    }

    @Override
    public void setView(ScanResultsContract.View view) {
        this.view = view;
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getResults(ScanActivity.ResultsEvent event) {
        if (view != null) {
            view.showResults(event.getResults());
        }
    }
}
