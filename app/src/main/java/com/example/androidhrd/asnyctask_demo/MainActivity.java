package com.example.androidhrd.asnyctask_demo;

import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView progressResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onDownload(View view) {
        //createProgressDialog();
        downloadAsyncTask.execute();
    }
    private AlertDialog alertDialog;
    private AsyncTask downloadAsyncTask= new AsyncTask<Void,Integer,Boolean>(){
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = createProgressDialog();
            alertDialog.show();
        }

        protected Boolean doInBackground(Void... voids) {
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
            if(progressBar!=null)
                progressBar.setProgress(values[0]);
            if(progressResult!=null)
                progressResult.setText(values[0]+"%");

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(progressResult!=null)
                progressResult.setText("Completed");
        }
    };

    public AlertDialog createProgressDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("downloading");
        builder.setNegativeButton("Cancel",(dialog,v)->{
            dialog.dismiss();
        });
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.progresbar_layout,null
        );
         progressBar=view.findViewById(R.id.progressBar);
         progressResult=view.findViewById(R.id.progresValue);
        builder.setView(view);

        return builder.create();
    }

}
