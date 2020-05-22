package com.example.rode.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rode.Logic.noteArrayAdapter;
import com.example.rode.NetworkLayer.DatabaseFB.DashBoardData;
import com.example.rode.NetworkLayer.DatabaseFB.IdCounter;
import com.example.rode.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class notesUserUI extends Fragment {
    DashBoardData dashBoardData;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    ArrayList <String> notes = new ArrayList<>();
    @BindView(R.id.note_list)
    RecyclerView recyclerView;
    @BindView(R.id.user_note_course_title)
    TextView courseTitle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashBoardData=new DashBoardData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes_user_ui, container, false);
        ButterKnife.bind(this, view);
        progressBar.setVisibility(View.INVISIBLE);


        return  view ;
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
