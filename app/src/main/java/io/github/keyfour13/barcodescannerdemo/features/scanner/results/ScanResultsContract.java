package io.github.keyfour13.barcodescannerdemo.features.scanner.results;


import io.github.keyfour13.barcodescannerdemo.features.scanner.ScanActivity;

public interface ScanResultsContract {

    interface View {
        void showMessage(String message);
        void showResults(String results);
    }

    interface Presenter {
        void setView(ScanResultsContract.View view);
        void getResults(ScanActivity.ResultsEvent event);
    }

}
