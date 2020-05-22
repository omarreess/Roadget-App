package com.example.rode.UI;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rode.Data.Course;
import com.example.rode.Data.UserCourses;
import com.example.rode.Logic.myCourseArrayAdapter;
import com.example.rode.NetworkLayer.DatabaseFB.CourseData;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class mycoursesAdminUI extends Fragment {
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.admin_mycourse_frame)
    FrameLayout newCourse;
    @BindView(R.id.admin_mycourse_title)
    TextView title;
    CourseData userCourses ;

    @Override
    public void onStart() {
        userCourses = new CourseData();
        userCourses.getUserCoursesByBidList(progressBar,getView() , gettingTypeFromBundle());
        super.onStart();
    }

    @OnClick(R.id.admin_mycourse_frame)
    public void addCourse() {

        Navigation.findNavController(getView()).navigate(R.id.action_mycoursesAdminUI_to_createCourseUI );      }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mycourses_admin_ui, container, false);
        ButterKnife.bind(this, view);
        if(!gettingTypeFromBundle().equals("falseAdmin") )
        {
            title.setText("Choose a Course");

        }


        return view ;

    }
public String gettingTypeFromBundle ()
{
    Bundle bundle = this.getArguments() ;
   return bundle.getString("type");
}

}
