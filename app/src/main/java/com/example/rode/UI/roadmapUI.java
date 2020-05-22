package com.example.rode.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rode.Data.Fields;
import com.example.rode.Logic.roadArrayAdapter;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class roadmapUI extends Fragment {
    @BindView(R.id.road_list)
    RecyclerView recyclerView;
    @BindView(R.id.road_title)
    TextView subFieldTitle;
    @BindView(R.id.road_next_show_course)
    FloatingActionButton showCoursesNext;
    @BindView(R.id.roadmap_profile)
    ImageView profile;
    @OnClick(R.id.roadmap_profile)
    public void toprofile() {

      checkUserAdmin(UserData.user.getType());
    }

   String currentSubField;
     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_roadmap_ui, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();


        currentSubField= bundle.getString("subField");
        subFieldTitle.setText(currentSubField);
        listForFields();
        return view;
    }
    public void listForFields()
    {
        Fields subfield = new Fields();
        ArrayList<String> roadList = subfield.checkRoadmap(currentSubField);


        roadArrayAdapter roadArrayAdapter = new roadArrayAdapter(R.layout.item_road, roadList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
         recyclerView.setAdapter(roadArrayAdapter);
    }
    @OnClick (R.id.road_next_show_course)
    public void toShowCourses() {
        Bundle bundle = new Bundle();
        bundle.putString("subField" ,currentSubField );
        Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_roadmapUI_to_coursesUI  , bundle);
    }
    @OnClick(R.id.roadmap_back)
    public void returnBack() {

        Navigation.findNavController(Objects.requireNonNull(getView())).navigateUp();
    }
    public void checkUserAdmin (String type){
        if (type.equals("User"))
        {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_roadmapUI_to_profileUserUI );
        }
        else {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_roadmapUI_to_profileAdminUI );
        }
    }

}
