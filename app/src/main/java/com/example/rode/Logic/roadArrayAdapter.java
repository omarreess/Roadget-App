package com.example.rode.Logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rode.Data.Fields;
import com.example.rode.R;

import java.util.ArrayList;
import java.util.Objects;

public class roadArrayAdapter extends RecyclerView.Adapter<roadArrayAdapter.ViewHolder> {
         //All methods in this adapter are required for a bare minimum recyclerview adapter
        private int listItemLayout;
        private ArrayList<String> itemList;
         // Constructor of the class
        public roadArrayAdapter(int layoutId, ArrayList<String> itemList) {
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
            TextView item = holder.item;
            item.setText(itemList.get(listPosition));
            ImageView circle = holder.circle;
            ImageView rectangle = holder.rectangle;
            rectangle.setVisibility(View.VISIBLE);
            circle.setImageResource(R.drawable.ic_rode_circle);

                if (holder.getLayoutPosition()==(itemList.size()-1)){
                    rectangle.setVisibility(View.INVISIBLE);
                     }
            if (holder.getLayoutPosition()==0){
                  circle.setImageResource(R.drawable.ic_rode_cirlce_fade);
             }



        }

        // Static inner class to initialize the views of rows
        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView item;
            public ImageView circle;
            public ImageView rectangle;

            public View view;
            public ViewHolder(View itemView) {
                super(itemView);
                view=itemView;

                itemView.setOnClickListener(this);
                item = (TextView) itemView.findViewById(R.id.text_road_item);
                circle = view.findViewById(R.id.item_rode_circle);
                rectangle = view.findViewById(R.id.rode_rectangle);
            }
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Fields field = new Fields();
                            //bundle.putString("field" , field.getFieldsTittles().get(getAdapterPosition()) );
              // Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_fieldsUI_to_subField , bundle );
             }
        }
    }