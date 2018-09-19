package com.example.androidhrd.asnyctask_demo;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

public class DownloadAsyncTask extends AsyncTask<String,Integer,Boolean> {
    private AppCompatActivity activity;
    private DownloadProgressBar downloadProgressBar;
    public DownloadAsyncTask(AppCompatActivity activity){
        this.activity=activity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        downloadProgressBar=new DownloadProgressBar();
        downloadProgressBar.show(activity.getSupportFragmentManager(),"progressBar");
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        for(int i =0;i<100;i++){
            publishProgress(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        downloadProgressBar.updateProgressValue(values[0]);
        downloadProgressBar.updateProgressResult(values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        downloadProgressBar.updateProgressResult("completed");
    }
}
