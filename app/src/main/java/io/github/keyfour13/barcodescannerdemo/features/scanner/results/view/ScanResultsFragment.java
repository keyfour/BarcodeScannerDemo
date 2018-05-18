package io.github.keyfour13.barcodescannerdemo.features.scanner.results.view;

import android.app.Activity;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsContract;

public class ScanResultsFragment extends Fragment implements ScanResultsContract.View {

    ScanResultsContract.Presenter presenter;

    public static ScanResultsFragment newInstance() {
        return new ScanResultsFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        AndroidSupportInjection.inject(this);
        super.onAttach(activity);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showResults(String results) {

    }

    @Override
    public void setButtonState() {

    }
}
