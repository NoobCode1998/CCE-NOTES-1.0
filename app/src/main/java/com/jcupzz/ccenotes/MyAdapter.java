package com.jcupzz.ccenotes;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


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
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName+"("+MainActivity.s4s6s8var+")"+fileExtension);
        Toast.makeText(context,"Downloading", Toast.LENGTH_SHORT).show();
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
                //myViewHolder.mDownload.setForeground(ContextCompat.getDrawable(v.getContext(), R.drawable.ic_check_circle_black_24dp));
            }


        });


    }

    @Override
    public int getItemCount() {

        return downModels.size();
    }


}
