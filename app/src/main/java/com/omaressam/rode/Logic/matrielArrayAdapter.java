package com.omaressam.rode.Logic;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.omaressam.rode.NetworkLayer.DatabaseFB.DashBoardData;
import com.omaressam.rode.NetworkLayer.DatabaseFB.IdCounter;
import com.omaressam.rode.R;

import java.util.ArrayList;

import static android.content.Intent.ACTION_VIEW;

public class matrielArrayAdapter extends RecyclerView.Adapter<matrielArrayAdapter.ViewHolder> {
         //All methods in this adapter are required for a bare minimum recyclerview adapter
        private int listItemLayout;
        public ArrayList<String> itemList;

    // Constructor of the class
        public matrielArrayAdapter(int layoutId, ArrayList<String> itemList) {
            listItemLayout = layoutId;
            this.itemList = itemList;

        }
    public void addingItem (String newItem)
    {
        itemList.add(newItem);
    }
        // get the size of the list
        @Override
        public int getItemCount() {
            return itemList == null ? 0 : itemList.size();
        }


        // specify the row layout file and click for each row
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
            ViewHolder myViewHolder = new ViewHolder(view);
            return myViewHolder;
        }

        // load data in each row element
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
            TextView matrieladress = holder.matrielAdress;
            matrieladress.setText(itemList.get(listPosition));
        }

        // Static inner class to initialize the views of rows
        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView matrielAdress;
            public View view;

            public ViewHolder(View itemView) {
                super(itemView);
                view=itemView;
                 view.setOnClickListener(this);
                matrielAdress = (TextView) itemView.findViewById(R.id.text_note_matriel_textview);
            }
            @Override
            public void onClick(View view) {
                 //Download and open file in external app
               try {
                    openAndDownloadPdf(DashBoardData.matrielLists.get(getLayoutPosition()) , "Roadget File "+ IdCounter.dashboradMatrielID);
               }
               catch (Exception e)
               {}
             }
            public void openAndDownloadPdf (String uriString , String name){
                Uri uri = Uri.parse(uriString);
                downloadBylink(uri , name);



            }
            public void downloadBylink  ( Uri uri , String name )
            {


                DownloadManager downloadmanager = (DownloadManager) view.getContext().   getSystemService(Context.DOWNLOAD_SERVICE);

                DownloadManager.Request request = new DownloadManager.Request(uri);
                 request.setTitle(name) ;
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(view.getContext(), Environment.getDataDirectory().toString(), name);

                openPdf( downloadmanager.getUriForDownloadedFile(downloadmanager.enqueue(request)) );




            }
            public  void openPdf(Uri uriLocal)
            {  Intent myIntent = new Intent(ACTION_VIEW);
                myIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                 myIntent.setDataAndType(uriLocal ,"application/pdf");
                Intent j = Intent.createChooser(myIntent, "Choose an application to open with:");
                view.getContext().startActivity(j);

            }
        }
    }