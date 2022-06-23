package com.example.bestbooksrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

import com.example.bestbooksrecyclerview.databinding.ActivityReadBookBinding;

import java.io.File;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class ReadBookActivity extends AppCompatActivity implements DownloadFile.Listener  {

    ActivityReadBookBinding binding;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReadBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progress = new ProgressDialog(this);
        progress.setTitle("LOADING");
        progress.setMessage("Wait While Loading");
        progress.show();

        String url = getIntent().getStringExtra("url");
        RemotePDFViewPager remotePDFViewPager =
                new RemotePDFViewPager(ReadBookActivity.this, url, this);
    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        PDFPagerAdapter adapter = new PDFPagerAdapter(this, extractFileNameFromUrl(url));
        binding.pdfViewPager.setAdapter(adapter);
        progress.dismiss();
    }

    public static String extractFileNameFromUrl(String url) {
        return url.substring(url.lastIndexOf('/')+1);
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}