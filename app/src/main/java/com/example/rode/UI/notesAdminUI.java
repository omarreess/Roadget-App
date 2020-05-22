package com.example.rode.UI;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rode.Logic.noteArrayAdapter;
import com.example.rode.NetworkLayer.DatabaseFB.DashBoardData;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class notesAdminUI extends Fragment {
    DashBoardData dashBoardData;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.note_list)
    RecyclerView recyclerView;
    @BindView(R.id.admin_note_course_title)
    TextView courseTitle;
    ArrayList<String> notes = new ArrayList<>();
    @BindView(R.id.Admin_note_add)
    LinearLayout addFrame;
    @BindView(R.id.type_note_edittext)
    EditText noteEditText;
    noteArrayAdapter noteArrayAdapter ;
    @OnClick( R.id.add_note_img)

    public void addNoteIcon() {
        // Toast.makeText(getContext(), "File", Toast.LENGTH_SHORT).show();
        addFrame.setVisibility(View.INVISIBLE);
    }


    @OnClick(R.id.add_note_text )
     public void addNoteIcon2() {
       // Toast.makeText(getContext(), "File", Toast.LENGTH_SHORT).show();
        addFrame.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.type_note_btn)
    public void addNoteBtn() {

        String newNote = noteEditText.getText().toString();
        noteEditText.setText("");
        DashBoardData.notesLists.add(newNote);

           dashBoardData.noteArrayAdapter.notifyDataSetChanged();
         dashBoardData.setNoteDashboard(getBundleandId() , newNote);


         addFrame.setVisibility(View.VISIBLE);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashBoardData = new DashBoardData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_notes_admin_ui, container, false);
        ButterKnife.bind(this, view);





        return view ;
    }
    public int  getBundleandId ()
    {    // getting course id for request of it
        Bundle bundle = this.getArguments();
        return bundle.getInt("id");

    }

    @Override
    public void onStart() {
        dashBoardData.getNoteDashboard(progressBar , getView() , recyclerView,  getBundleandId());

        super.onStart();
    }
}
