package com.omaressam.rode.NetworkLayer.DatabaseFB;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omaressam.rode.Data.User;
import com.omaressam.rode.Data.UserAdminRequests;
import com.omaressam.rode.Data.UserCourses;
import com.omaressam.rode.Logic.requestsArrayAdapter;
import com.omaressam.rode.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class UserData {
    static public User user = new User();
    static public  ArrayList <UserCourses> userCoursesBid = new ArrayList<UserCourses>();




    public void initializeFB(String uid)
    {
        setUserFB(uid);
    }

    public void  setUserFB(String uid)
    {
        user.setId(uid);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User");
        myRef.child(uid).setValue(user);

    }

    public  void getUserFB (ProgressBar progressBar , View view , String uid)
     {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User").child(uid);

         myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                myRef.removeEventListener((ValueEventListener) this);
                checkUserAdmin(progressBar , view , UserData.user.getType());


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
     }

     public void setUserCoursesFB(int bid , String aid)
     {
         UserCourses userCourses = new UserCourses();
         userCourses.setBid(bid);
         FirebaseDatabase database = FirebaseDatabase.getInstance();
         DatabaseReference myRef = database.getReference("UserCourses");
         myRef.child(aid).child(""+bid).setValue(userCourses);

     }
     public void getUserCoursesBidFB()
     {
         //getting courses statues and its id to get details by   id of those accepted
           FirebaseDatabase database = FirebaseDatabase.getInstance();
         DatabaseReference myRef = database.getReference("UserCourses").child(UserData.user.getId());

         myRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 userCoursesBid=new ArrayList<>();
                 for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                     userCoursesBid.add(childDataSnapshot.getValue(UserCourses.class))  ;

                  }

                   myRef.removeEventListener((ValueEventListener) this);

             }

             @Override
             public void onCancelled(DatabaseError error) {
                 // Failed to read value
             }
         });
      }


      public void setUserRequest (int bid , String uid )
      {
          UserAdminRequests userAdminRequests = new UserAdminRequests();
          userAdminRequests.setUid(uid);
          FirebaseDatabase database = FirebaseDatabase.getInstance();
          DatabaseReference myRef = database.getReference("UserAdminRequests");
          myRef.child(""+bid).child(uid).setValue(userAdminRequests);
       setUserCoursesFB(bid , uid);
      }


    public  void getUserRequests( ProgressBar progressBar ,  View view , int bid )
    {
        progressBar.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = view.findViewById(R.id.admin_requests_list);

        ArrayList<UserAdminRequests> AdminRequestsListUid = new ArrayList<>();
        ArrayList<User>  AdminRequestsList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

         myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // getting list of uid requested users
                for (DataSnapshot childDataSnapshot :  dataSnapshot.child("UserAdminRequests").child(""+bid).getChildren()) {
                    if (childDataSnapshot.getValue(UserAdminRequests.class).getAccepted().equals(Boolean.FALSE))
                    {
                        AdminRequestsListUid.add(childDataSnapshot.getValue(UserAdminRequests.class));

                    }

                }

                 if (AdminRequestsListUid.size()==0){
                     Toast.makeText(view.getContext(), " No Requests at this time ", Toast.LENGTH_SHORT).show();
                 }
                 else { //getting list of real data of users

                     for (DataSnapshot childDataSnapshot :  dataSnapshot.child("User").getChildren()) {
                         for (int i = 0; i < AdminRequestsListUid.size(); i++) {
                             if (AdminRequestsListUid.get(i).getUid().equals(childDataSnapshot.getKey()))
                             {
                                 AdminRequestsList.add(childDataSnapshot.getValue(User.class));
                             }
                         }
                     }
                     //seting the list
                     requestsArrayAdapter requestsArrayAdapter = new requestsArrayAdapter(R.layout.item_request,bid, AdminRequestsList);
                     recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                     recyclerView.setItemAnimator(new DefaultItemAnimator());
                     recyclerView.setAdapter(requestsArrayAdapter);
                 }

                progressBar.setVisibility(View.INVISIBLE);

                myRef.removeEventListener((ValueEventListener) this);

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }


    public void setStatuesRequest (Boolean status , int bid , String uid )
    {
         FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("UserAdminRequests").child(""+bid).child(uid).child("accepted").setValue(status);
        myRef.child("UserCourses").child(uid).child(""+bid).child("accepted").setValue(status);

     }
    public void setUserCoursesFeedback(int bid , String aid , String feedback , int rate)
    {
        UserCourses userCourses = new UserCourses();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("UserCourses").child(aid).child(bid+"");
        myRef.child("feedback").setValue(feedback);
        myRef.child("rate").setValue(rate);



    }

    private void checkUserAdmin (ProgressBar progressBar  , View view , String type) {
        if (type.equals("User")) {
            Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_loginUI_to_fieldsUI);
        } else {
            Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_loginUI_to_profileAdminUI);
        }
        progressBar.setVisibility(View.INVISIBLE);
    }

}
