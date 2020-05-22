package com.example.rode.Logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rode.Data.Course;
import com.example.rode.R;

import java.util.ArrayList;
import java.util.Objects;

public class coursesArrayAdapter extends RecyclerView.Adapter<coursesArrayAdapter.ViewHolder> {
         //All methods in this adapter are required for a bare minimum recyclerview adapter
        private int listItemLayout;
       public static ArrayList<Course> itemList;
        // Constructor of the class
        public coursesArrayAdapter(int layoutId, ArrayList<Course> itemList) {
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
      TextView location = holder.location;
            TextView placeName = holder.placeName;
         TextView price = holder.price;
          TextView rate = holder.rate;
            TextView roadmapRate = holder.roadmapRate;

    placeName.setText(itemList.get(listPosition).getPlaceName());
        location.setText(itemList.get(listPosition).getLocation());
            price.setText(""+itemList.get(listPosition).getPrice()+" EGP");
      rate.setText("" +itemList.get(listPosition).getRate());
   roadmapRate.setText(itemList.get(listPosition).getRoadmapRate()+"%");




        }

        // Static inner class to initialize the views of rows
        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
           public TextView placeName;
            public TextView rate;
            public TextView roadmapRate;
            public TextView price;

            public TextView location;

            public View view;

            public ViewHolder(View itemView) {
                super(itemView);
                view=itemView;

                itemView.setOnClickListener(this);
                 placeName = (TextView) itemView.findViewById(R.id.course_list_place);
                rate = (TextView) itemView.findViewById(R.id.course_list_rate_course);
                roadmapRate = (TextView) itemView.findViewById(R.id.course_list_rate_roadmap);
                price = (TextView) itemView.findViewById(R.id.course_list_price);
                location = (TextView) itemView.findViewById(R.id.course_list_location);


            }
            @Override
            public void onClick(View view) {
                 Bundle bundle = new Bundle();
                  bundle.putString("date" ,itemList.get(getLayoutPosition()).getDate() );
                 bundle.putString("price" ,price.getText().toString() );
                bundle.putString("rate" ,rate.getText().toString() );
                bundle.putString("roadrate" ,roadmapRate.getText().toString() );
                bundle.putString("placename" ,placeName.getText().toString() );
                bundle.putString("location" ,location.getText().toString() );
                bundle.putString("disc" ,itemList.get(getLayoutPosition()).getDescreption());
                bundle.putString("instructor" ,itemList.get(getLayoutPosition()).getInstructor() );
                bundle.putString("aid" ,itemList.get(getLayoutPosition()).getAID() );
                bundle.putInt("bid" ,itemList.get(getLayoutPosition()).getId() );





                Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_coursesUI_to_courseDetailsUI , bundle );
             }
        }
    }