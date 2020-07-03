package com.omaressam.rode.NetworkLayer.DatabaseFB;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class IdCounter {
    static public int courseID ;
    static public  int dashboradNotesID;
    static public  int dashboradMatrielID;


     public  void getIDs ()
     {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

         myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                courseID = dataSnapshot.child("CountBid").getValue(int.class);
                dashboradMatrielID = dataSnapshot.child("CountMatrielId").getValue(int.class);
                dashboradNotesID = dataSnapshot.child("CountNotesId").getValue(int.class);

                myRef.removeEventListener((ValueEventListener) this);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
     }


    public void  setIncreamentNoteID()
    {

  dashboradNotesID++;
         FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
         myRef.child("CountNotesId").setValue(dashboradNotesID);


    }
    public void  setIncreamentMatrielID()
    {

        dashboradMatrielID++;
         FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
         myRef.child("CountMatrielId").setValue(dashboradMatrielID);


    }
    public void  setIncreamentCourseID(int bid)
    {
        courseID = bid;
        courseID++;
         FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("CountBid").setValue(courseID);


    }

}
