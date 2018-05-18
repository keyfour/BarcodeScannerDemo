package io.github.keyfour13.barcodescannerdemo.features.scanner.results.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;
import io.github.keyfour13.barcodescannerdemo.R;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsContract;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter.ScanResultsPresenter;

public class ScanResultsFragment extends Fragment implements ScanResultsContract.View {


    @BindView(R.id.tvResults)
    TextView textView;

    @Inject @Singleton
    ScanResultsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scan, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        AndroidSupportInjection.inject(this);
        super.onAttach(activity);
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showResults(String results) {
        if (textView != null && results != null) {
            textView.setText(results);
        }
    }

}
