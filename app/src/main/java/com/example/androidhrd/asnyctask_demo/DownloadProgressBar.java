package com.example.androidhrd.asnyctask_demo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadProgressBar extends DialogFragment {

    private ProgressBar progressBar;
    private TextView progressResult;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
        builder.setTitle("downloading");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.progresbar_layout,null);
        progressBar=view.findViewById(R.id.progressBar);
        progressResult=view.findViewById(R.id.progresValue);
        builder.setView(view);
        builder.setCancelable(false);
        builder.setNegativeButton("Cancel",(dialog,v)->{
            dialog.dismiss();
        });
        return builder.create();
    }

    public void updateProgressValue(int value){
        if(progressBar!=null)
            progressBar.setProgress(value);
    }
    public void updateProgressResult(String value){
        if(progressResult!=null)
            progressResult.setText(value);
    }
}
