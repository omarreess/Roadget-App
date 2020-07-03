package com.omaressam.rode.Logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.omaressam.rode.Data.User;
import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData;
import com.omaressam.rode.R;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class requestsArrayAdapter extends RecyclerView.Adapter<requestsArrayAdapter.ViewHolder> {
         //All methods in this adapter are required for a bare minimum recyclerview adapter
        private int listItemLayout;
        public  static int courseId;
        public static ArrayList<User> requestsList;

    // Constructor of the class
        public requestsArrayAdapter(int layoutId , int courseId, ArrayList<User> itemList) {
            listItemLayout = layoutId;
            this.courseId = courseId;
            this.requestsList = itemList;
        }

        // get the size of the list
        @Override
        public int getItemCount() {
            return requestsList == null ? 0 : requestsList.size();
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
             TextView userMail = holder.userMail;
              TextView userName = holder.userName;
            ImageView userAccept = holder.userAccept;
            ImageView userReject = holder.userReject;
            userMail.setText(requestsList.get(listPosition).getMail());
            userName.setText(requestsList.get(listPosition).getFullname());


        }

        // Static inner class to initialize the views of rows
        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView userName;
            public TextView userMail;
            public ImageView userAccept;
            public ImageView userReject;

            public TextView done;

            public View view;
            public ViewHolder(View itemView) {
                super(itemView);
                view=itemView;

                itemView.setOnClickListener(this);
                userMail =  itemView.findViewById(R.id.item_request_course);
                userName =  itemView.findViewById(R.id.item_request_name);
                userAccept =  itemView.findViewById(R.id.item_request_accept);
                userReject =  itemView.findViewById(R.id.item_request_reject);
                done = itemView.findViewById(R.id.item_request_done);
                userAccept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        done.setVisibility(View.VISIBLE);
                         userAccept.setVisibility(View.GONE);
                        userReject.setVisibility(View.GONE);
                         UserData userData = new UserData();
                        userData.setStatuesRequest(TRUE ,courseId ,requestsList.get(getLayoutPosition()).getId()  );
                    }
                });
                userReject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        done.setVisibility(View.VISIBLE);

                        userAccept.setVisibility(View.GONE);
                        userReject.setVisibility(View.GONE);
                        UserData userData = new UserData();

                        userData.setStatuesRequest(FALSE ,courseId ,requestsList.get(getLayoutPosition()).getId()  );




                    }
                });
             }

            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Fields field = new Fields();
                                //bundle.putString("field" , field.getFieldsTittles().get(getAdapterPosition()) );
              // Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_fieldsUI_to_subField , bundle );
             }
        }
    }