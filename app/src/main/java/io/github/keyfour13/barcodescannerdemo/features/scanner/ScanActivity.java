package io.github.keyfour13.barcodescannerdemo.features.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.github.keyfour13.barcodescannerdemo.R;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.DaggerScanResultsContract;
import io.github.keyfour13.barcodescannerdemo.features.scanner.results.ScanResultsContract;
import io.github.keyfour13.barcodescannerdemo.scanner.DaggerScannerComponent;
import io.github.keyfour13.barcodescannerdemo.scanner.Scanner;
import io.github.keyfour13.barcodescannerdemo.utils.DaggerUrlUtils;
import io.github.keyfour13.barcodescannerdemo.utils.UrlValidationUtil;

/**
 * ${COPYRIGHT}
 * <p>
 * Created by aleksandr on 18.05.18.
 */

public class ScanActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    ScanResultsContract.Presenter presenter;
    UrlValidationUtil validationUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        Scanner scanner = DaggerScannerComponent.builder().build().scanner();
        presenter = DaggerScanResultsContract.builder().build().providePresenter();
        validationUtil = DaggerUrlUtils.builder().build().validationUtil();
        scanner.scan(this);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                if(validationUtil.validateHTTP_URI(result.getContents())) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(result.getContents()));
                    startActivity(intent);
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
