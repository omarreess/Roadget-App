package com.example.rode.Logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rode.R;

import java.util.ArrayList;

public class noteArrayAdapter extends RecyclerView.Adapter<noteArrayAdapter.ViewHolder> {
         //All methods in this adapter are required for a bare minimum recyclerview adapter
        private int listItemLayout;
        private ArrayList<String> itemList;

        // Constructor of the class
        public noteArrayAdapter(int layoutId, ArrayList<String> itemList) {
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
            TextView item = holder.item;
            item.setText(itemList.get(listPosition));
        }

        // Static inner class to initialize the views of rows
        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView item;
            public View view;
            public ViewHolder(View itemView) {
                super(itemView);
                view=itemView;

                itemView.setOnClickListener(this);
                item = (TextView) itemView.findViewById(R.id.text_note_matriel_textview);
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