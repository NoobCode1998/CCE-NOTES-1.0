package com.jcupzz.ccenotes;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class DownloadReceiver extends BroadcastReceiver {
public static String downloadFilePath;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action==DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0));
            DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            Cursor cursor = manager.query(query);
            if (cursor.moveToFirst()) {
                if (cursor.getCount() > 0) {

                    int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
                    Long download_id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,0);
                    // status contain Download Status
                    // download_id contain current download reference id
                    int columnReason = cursor.getColumnIndex(DownloadManager.COLUMN_REASON);
                    int reason = cursor.getInt(columnReason);

                    if(download_id==MyAdapter.DownloadId)
                    {
                        Toast.makeText(context,"Download Completed ",Toast.LENGTH_LONG).show();


                        //change icon
                        //change icon
                        downloadFilePath = null;
                        String downloadFileLocalUri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                        if (downloadFileLocalUri != null) {
                            File mFile = new File(Uri.parse(downloadFileLocalUri).getPath());
                            downloadFilePath = mFile.getAbsolutePath();
                        }
                        MyAdapter.download_completed_status=true;
                    }

                    String statusText = " ";
                    String reasonText = " ";

                    switch(status){
                        case DownloadManager.STATUS_FAILED:
                            statusText = "STATUS_FAILED";
                            switch(reason){
                                case DownloadManager.ERROR_CANNOT_RESUME:
                                    reasonText = "ERROR_CANNOT_RESUME";
                                    break;
                                case DownloadManager.ERROR_DEVICE_NOT_FOUND:
                                    reasonText = "ERROR_DEVICE_NOT_FOUND";
                                    break;
                                case DownloadManager.ERROR_FILE_ALREADY_EXISTS:
                                    reasonText = "ERROR_FILE_ALREADY_EXISTS";
                                    break;
                                case DownloadManager.ERROR_FILE_ERROR:
                                    reasonText = "ERROR_FILE_ERROR";
                                    break;
                                case DownloadManager.ERROR_HTTP_DATA_ERROR:
                                    reasonText = "ERROR_HTTP_DATA_ERROR";
                                    break;
                                case DownloadManager.ERROR_INSUFFICIENT_SPACE:
                                    reasonText = "ERROR_INSUFFICIENT_SPACE";
                                    break;
                                case DownloadManager.ERROR_TOO_MANY_REDIRECTS:
                                    reasonText = "ERROR_TOO_MANY_REDIRECTS";
                                    break;
                                case DownloadManager.ERROR_UNHANDLED_HTTP_CODE:
                                    reasonText = "ERROR_UNHANDLED_HTTP_CODE";
                                    break;
                                case DownloadManager.ERROR_UNKNOWN:
                                    reasonText = "ERROR_UNKNOWN";
                                    break;
                            }
                            Toast.makeText(context,"Download Failed Status: "+statusText+"\nDue to: "+reasonText,Toast.LENGTH_LONG).show();
                            removeTempOnFailure(context,download_id);
                            break;
                        case DownloadManager.STATUS_PAUSED:
                            statusText = "STATUS_PAUSED";
                            switch(reason){
                                case DownloadManager.PAUSED_QUEUED_FOR_WIFI:
                                    reasonText = "PAUSED_QUEUED_FOR_WIFI";
                                    break;
                                case DownloadManager.PAUSED_UNKNOWN:
                                    reasonText = "PAUSED_UNKNOWN";
                                    break;
                                case DownloadManager.PAUSED_WAITING_FOR_NETWORK:
                                    reasonText = "PAUSED_WAITING_FOR_NETWORK";
                                    break;
                                case DownloadManager.PAUSED_WAITING_TO_RETRY:
                                    reasonText = "PAUSED_WAITING_TO_RETRY";
                                    break;
                            }
                            Toast.makeText(context,"Download Status: "+statusText+"\nDue to: "+reasonText,Toast.LENGTH_LONG).show();
                            break;
                        case DownloadManager.STATUS_PENDING:
                            statusText = "STATUS_PENDING";
                            Toast.makeText(context,"Download Status: "+statusText,Toast.LENGTH_LONG).show();
                            break;
                        case DownloadManager.STATUS_RUNNING:
                            statusText = "STATUS_RUNNING";
                            Toast.makeText(context,"Download Status: "+statusText,Toast.LENGTH_LONG).show();
                            break;
                        case DownloadManager.STATUS_SUCCESSFUL:
                            statusText = "STATUS_SUCCESSFUL";
                            Toast.makeText(context,"Download Status: "+statusText,Toast.LENGTH_LONG).show();
                            break;
                    }


                }
            }
        }


    }
    private void removeTempOnFailure(Context con, long downloadId) {
        File cacheFileDir = new File(con.getCacheDir().getAbsolutePath());
        for (File f : cacheFileDir.listFiles()) {
            if (f.getName().contains(String.valueOf(downloadId))) {
                f.delete();
                break;
            }
        }
    }
}