package com.jcupzz.ccenotes;

import android.app.DownloadManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    MainActivity mainActivity;
    ArrayList<DownModel> downModels;



    public MyAdapter(MainActivity mainActivity, ArrayList<DownModel> downModels) {
        this.mainActivity = mainActivity;
        this.downModels = downModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = layoutInflater.inflate(R.layout.elements, null, false);
        return new MyViewHolder(view);
    }

    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);
        Toast.makeText(context,"Downloading!!!", Toast.LENGTH_SHORT).show();
        //request.setDestinationInExternalPublicDir(context,destinationDirectory,fileName+fileExtension);
        downloadmanager.enqueue(request);

    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.mName.setText(downModels.get(i).getName());
        //myViewHolder.mLink.setText(downModels.get(i).getLink());
        myViewHolder.mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    downloadFile(myViewHolder.mName.getContext(), downModels.get(i).getName(), ".pdf", null, downModels.get(i).getLink());
            }


        });


    }

    @Override
    public int getItemCount() {

        return downModels.size();
    }


}
