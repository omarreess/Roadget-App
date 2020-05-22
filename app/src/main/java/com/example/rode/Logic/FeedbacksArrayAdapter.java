package com.example.rode.Logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rode.Data.Course;
import com.example.rode.Data.UserCourses;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;

import java.util.ArrayList;
import java.util.Objects;

public class FeedbacksArrayAdapter extends RecyclerView.Adapter<FeedbacksArrayAdapter.ViewHolder> {
    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    static String typeFromBundle;
    public static ArrayList<UserCourses> itemList;

    // Constructor of the class
    public FeedbacksArrayAdapter(int layoutId, ArrayList<UserCourses> itemList) {
        listItemLayout = layoutId;
        this.itemList = itemList;
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
        TextView name = holder.name;
        TextView rate = holder.rate;
        TextView feedback = holder.feedback;

        // name.setText(itemList.get(listPosition).get());
        rate.setText(itemList.get(listPosition).getRate());
        feedback.setText(itemList.get(listPosition).getFeedback());


    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView rate;
        public TextView feedback;


        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.item_feedback_name);
            rate = (TextView) itemView.findViewById(R.id.item_feedback_rate);
            feedback = (TextView) itemView.findViewById(R.id.item_feedback_review);


        }

        @Override
        public void onClick(View view) {


        }

    }
}