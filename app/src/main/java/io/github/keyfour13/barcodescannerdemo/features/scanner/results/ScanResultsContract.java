package io.github.keyfour13.barcodescannerdemo.features.scanner.results;


public interface ScanResultsContract {

    interface View {
        void showMessage(String message);
        void showResults(String results);
        void setButtonState();
        void setPresenter(ScanResultsContract.Presenter presenter);
    }

    interface Presenter {
        void setView(ScanResultsContract.View view);
        void getResults();
    }

}
