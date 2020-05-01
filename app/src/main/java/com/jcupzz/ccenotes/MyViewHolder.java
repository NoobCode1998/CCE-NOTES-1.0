package com.jcupzz.ccenotes;

import android.app.Activity;
import android.app.Application;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, View.OnClickListener {
    public static String he;
public static String ve;
public static int l=0;
    public static String path;

TextView mName;
    Button mDownload;
    CardView mCardView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);



        mName = itemView.findViewById(R.id.name);
        mDownload = itemView.findViewById(R.id.down);
mCardView= itemView.findViewById(R.id.cardview_id);
mCardView.setOnCreateContextMenuListener(this);
mCardView.setOnClickListener(this);


}

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(StudentTeacherCategory.stc_integer==1) {
            menu.add(getAdapterPosition(), 121, 0, "Delete");
            ve = mName.getText().toString();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cardview_id) {
            he = mName.getText().toString();
            path = "/storage/self/primary/Android/data/com.jcupzz.ccenotes/files/" + he+"("+MainActivity.s4s6s8var+")"+".pdf";
            File file = new File(path);
            //Toast.makeText(v.getContext(),path,Toast.LENGTH_SHORT).show();
            if (file.exists()) {
                Toast.makeText(v.getContext(), "Opening "+he, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), PdfViewer.class);
                v.getContext().startActivity(intent);
            } else {
                Toast.makeText(v.getContext(), "This file is not found in your Storage!", Toast.LENGTH_SHORT).show();
            }
        }


    }
}
