package io.github.keyfour13.barcodescannerdemo.features.scanner.results;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ScanResultsModule.class})
public interface ScanResultsContract {

    interface View {
        void showMessage(String message);
        void showResults(String results);
        void setButtonState();
    }

    interface Presenter {
        void setView(ScanResultsContract.View view);
        void getResults();
    }

    Presenter providePresenter();

}
