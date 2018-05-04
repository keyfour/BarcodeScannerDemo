package io.github.keyfour13.barcodescannerdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.esafirm.rxdownloader.RxDownloader;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

import java.io.File;
import java.net.URI;

import rx.Subscriber;
import rx.Subscription;

public class PDFViewActivity extends AppCompatActivity implements OnPageChangeListener,
        OnLoadCompleteListener, OnErrorListener {

    private PDFViewActivity activity;
    private PDFView pdfView;
    private String fileName;
    private Subscriber<String> subscriber;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        activity = this;
        pdfView = (PDFView) findViewById(R.id.pdfView);

        fileName = getIntent().getExtras().getString("FileName");

    }

    @Override
    protected void onResume() {
        super.onResume();
        PDFView.Configurator configurator = null;
        String url = "http://192.168.1.254/uconfigs/mnt/" + fileName +".pdf";
        File f = new File(URI.create("file:///storage/emulated/0/Download/" + fileName + ".pdf"));
        if (f.exists()) {
            openFile(f);
        } else {
            if (subscriber == null) {
                subscriber = getSubscriber();
            }
            if (subscription == null) {
                subscription = RxDownloader.getInstance(this)
                        .download(url, fileName + ".pdf", "application/pdf") // url, filename, and mimeType
                        .subscribe(subscriber);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @NonNull
    private Subscriber<String> getSubscriber() {
        return new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(activity, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                File f = new File(URI.create("file:///storage/emulated/0/Download/" + fileName + ".pdf"));
            }

            @Override
            public void onNext(String s) {
                if (s != null) {
                    File file = new File(URI.create(s));
                    openFile(file);
                }
            }
        };
    }


    private void openFile(File file){
        if (file != null) {
            String path = file.getPath();
            File oFile = new File(path);
            pdfView.fromFile(file)
                    .enableSwipe(true)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .onLoad(activity)
                    .onPageChange(activity)
                    .onError(activity)
                    .enableAnnotationRendering(false)
                    .password(null)
                    .load();
        }
    }

    @Override
    public void loadComplete(int nbPages) {
        Toast.makeText(this, "1/" + nbPages, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        Toast.makeText(this, page + "/" + pageCount, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
