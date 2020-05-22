package com.example.rode.Logic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rode.Data.Course;
import com.example.rode.NetworkLayer.DatabaseFB.DashBoardData;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;

import java.util.ArrayList;
import java.util.Objects;

public class myCourseArrayAdapter extends RecyclerView.Adapter<myCourseArrayAdapter.ViewHolder> {
         //All methods in this adapter are required for a bare minimum recyclerview adapter
        private int listItemLayout;
        static String typeFromBundle;
       static Boolean   feedback = false ;
        public static ArrayList<Course> itemList;

    // Constructor of the class
        public myCourseArrayAdapter(int layoutId, ArrayList<Course> itemList , String type) {
            listItemLayout = layoutId;
            this.typeFromBundle = type;
            this.itemList = itemList;
        }
        public void addFeedback()
        {
            feedback=true;
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
             TextView head = holder.head;
              TextView place = holder.place;
              TextView price = holder.price;
              TextView status = holder.status;
              TextView date = holder.date;
            head.setText(itemList.get(listPosition).getCourseName());
            place.setText(itemList.get(listPosition).getPlaceName());
            price.setText(""+( itemList.get(listPosition).getPrice()));
             date.setText(itemList.get(listPosition).getDate());
             if (UserData.userCoursesBid.get(listPosition).getAccepted().toString().equals("false")  )
             {           status.setText("Rejected"); }
             else {status.setText("Accepted"); }


        }

        // Static inner class to initialize the views of rows
        static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            public TextView head;
            public TextView place;
            public TextView price;
            public TextView status;
            public TextView statusTextview;
            public TextView date;

            public View view;
            public ViewHolder(View itemView) {
                super(itemView);
                view=itemView;

                itemView.setOnClickListener(this);
                head = (TextView) itemView.findViewById(R.id.item_request_name);
                place = (TextView) itemView.findViewById(R.id.iteam_mycourse_place);
                price = (TextView) itemView.findViewById(R.id.item_mycourse_price);
                status = (TextView) itemView.findViewById(R.id.iteam_mycourse_status);
                statusTextview = (TextView) itemView.findViewById(R.id.item_status_textview);

                date = (TextView) itemView.findViewById(R.id.iteam_mycourse_date);


                switch (typeFromBundle){
                case "notesAdmin":
                    status.setVisibility(View.INVISIBLE);
                    statusTextview.setVisibility(View.INVISIBLE);

                 break;
                case "reqAdmin":
                    status.setVisibility(View.INVISIBLE);
                    statusTextview.setVisibility(View.INVISIBLE);

                    break;
                    case "matrielAdmin":
                        status.setVisibility(View.INVISIBLE);
                        statusTextview.setVisibility(View.INVISIBLE);

                        break;
                    case "falseAdmin":
                        status.setVisibility(View.INVISIBLE);
                        statusTextview.setVisibility(View.INVISIBLE);

                        break;
                    default : }


             }
            @Override
            public void onClick(View view) {
                 if(typeFromBundle != null)
                {                 detectNavigation();
                }
               feedback=false ;
             }
             public  void detectNavigation (){
                // to detect corect destination
                 Bundle newBundle = new Bundle();
                 newBundle.putString("title",itemList.get(getLayoutPosition()).getCourseName());
                  newBundle.putInt("id",itemList.get(getLayoutPosition()).getId());
                 switch(typeFromBundle) {
                          case "notesAdmin":
                         Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_mycoursesAdminUI_to_notesAdminUI , newBundle );
                         break;
                         case "reqAdmin":
                         Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_mycoursesAdminUI_to_requestsUI , newBundle );                         break;
                         case "matrielAdmin":
                         Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_mycoursesAdminUI_to_materialAdminUI , newBundle );
                         break;
                         case "matrielUser":
                             if(UserData.userCoursesBid.get(getLayoutPosition()).getAccepted())
                             { Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_mycourseUserUI_to_materialUserUI , newBundle );}
                             else
                             {
                                 Toast.makeText(itemView.getContext(), "Your Course Request Under Approval", Toast.LENGTH_SHORT).show();
                             }

                         break;
                         case "notesUser":
                             if(UserData.userCoursesBid.get(getLayoutPosition()).getAccepted())
                             { Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_mycourseUserUI_to_notesUserUI , newBundle ); }
                             else
                             {
                                 Toast.makeText(itemView.getContext(), "Your Course Request Under Approval", Toast.LENGTH_SHORT).show();
                             }

                         break;

                     default:
                         // code block
                 }
                  if (feedback)
                  { Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_mycourseUserUI_to_postFeedBackUI , newBundle );
                  }


             }
        }
     }