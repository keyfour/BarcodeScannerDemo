package io.github.keyfour13.barcodescannerdemo.features.scanner.results;


public interface ScanResultsContract {

    interface View {
        void showMessage(String message);
        void showResults(String results);
    }

    interface Presenter {
        void setView(ScanResultsContract.View view);
    }

}
