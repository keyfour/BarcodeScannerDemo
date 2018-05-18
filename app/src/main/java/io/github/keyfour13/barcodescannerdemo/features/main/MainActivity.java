package io.github.keyfour13.barcodescannerdemo.features.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.github.keyfour13.barcodescannerdemo.R;
import io.github.keyfour13.barcodescannerdemo.features.scanner.ScanActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onResume() {
        super.onResume();
        Observable.just(true)
                .delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DelayConsumer(this));
    }


    public class DelayConsumer implements Consumer<Boolean> {

        private Activity activity;

        public DelayConsumer(Activity activity){
            this.activity = activity;
        }

        @Override
        public void accept(Boolean bool) throws Exception {
            Intent intent = new Intent(activity, ScanActivity.class);
        }
    }


}
