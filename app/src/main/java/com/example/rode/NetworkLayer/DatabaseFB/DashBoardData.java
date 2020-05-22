package com.example.rode.NetworkLayer.DatabaseFB;

import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rode.Data.User;
import com.example.rode.Logic.matrielArrayAdapter;
import com.example.rode.Logic.noteArrayAdapter;
import com.example.rode.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.net.URI;
import java.util.ArrayList;

public class DashBoardData {
    public  noteArrayAdapter  noteArrayAdapter;
    public  matrielArrayAdapter matrielArrayAdapter;
    IdCounter idCounter = new IdCounter();

   public static  ArrayList<String> notesLists = new ArrayList<>();
  public   static  ArrayList<String> matrielLists = new ArrayList<>();
    public void setNoteDashboard(int bid , String note)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Dashboard Notes").child(bid+"");

       myRef.child(IdCounter.dashboradNotesID+"").setValue(note);
       idCounter.setIncreamentNoteID();


    }


    public void getNoteDashboard(ProgressBar progressBar , View view  ,  RecyclerView recyclerView, int bid )
    {
        progressBar.setVisibility(View.VISIBLE);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Dashboard Notes").child(bid+"");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                notesLists= new ArrayList<>();
                for (DataSnapshot childDataSnapshot :  dataSnapshot.getChildren()) {
                    notesLists.add(childDataSnapshot.getValue(String.class));
                       noteArrayAdapter = new noteArrayAdapter(R.layout.item_note_matriel, DashBoardData.notesLists);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(noteArrayAdapter);
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
    public void setMatrielDashboard(View view , int bid , Uri fileUri , String name )
    {
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference("Dashboard Materiel/"+name);
        mStorageRef.putFile(fileUri);
        Snackbar.make(view,"Uploading File ",Snackbar.LENGTH_LONG).show();

        mStorageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                DashBoardData.matrielLists.add(uri.toString());
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Dashboard Matriel").child(bid+"");
                myRef.child(IdCounter.dashboradMatrielID+"").setValue(uri.toString());
                idCounter.setIncreamentMatrielID();
                  matrielArrayAdapter.notifyDataSetChanged();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });



    }

    public void getMatrielDashboard(ProgressBar progressBar , View view , RecyclerView recyclerView, int bid )
    {
        progressBar.setVisibility(View.VISIBLE);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Dashboard Matriel").child(bid+"");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                matrielLists = new ArrayList<>();

                for (DataSnapshot childDataSnapshot :  dataSnapshot.getChildren()) {
                    matrielLists.add(childDataSnapshot.getValue(String.class));
                      matrielArrayAdapter = new matrielArrayAdapter(R.layout.item_note_matriel, DashBoardData.matrielLists);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(matrielArrayAdapter);
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
}
