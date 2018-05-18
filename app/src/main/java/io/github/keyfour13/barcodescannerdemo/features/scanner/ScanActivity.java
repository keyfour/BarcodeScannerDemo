package io.github.keyfour13.barcodescannerdemo.features.scanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.github.keyfour13.barcodescannerdemo.R;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.presenter.ScanResultsPresenter;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.view.ScanResultsFragment;
import io.github.keyfour13.barcodescannerdemo.scanner.ZXScanner;
import io.github.keyfour13.barcodescannerdemo.utils.UrlValidationUtil;

/**
 * ${COPYRIGHT}
 * <p>
 * Created by aleksandr on 18.05.18.
 */

public class ScanActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    ScanResultsFragment fragment;
    @Inject
    ScanResultsPresenter presenter;
    @Inject
    ZXScanner scanner;
    @Inject
    UrlValidationUtil validationUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        if (savedInstanceState == null) {
            scanner.scan(this);
            Fragment fragment = new ScanResultsFragment();
            getSupportFragmentManager().beginTransaction().add(fragment, "results_fraagment").commit();
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            ResultsEvent event = new ResultsEvent();
            event.results = result.getContents();
            presenter.setView(fragment);
            EventBus.getDefault().post(event);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(presenter);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(presenter);
    }

    public static class ResultsEvent {
        String results;

        public String getResults() {
            return results;
        }
    }
}
