package com.omaressam.rode.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.omaressam.rode.NetworkLayer.DatabaseFB.CourseData;
import com.omaressam.rode.R;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class mycourseUserUI extends Fragment {
    @BindView(R.id.user_mycourse_list)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.admin_mycourse_title)
    TextView title;
    CourseData userCourses ;
    @BindView(R.id.user_mycourse_feedback)
    TextView feedback;
    @OnClick(R.id.user_mycourse_feedback)
     public void chooseCourseForFeedback ()
    {
        userCourses.FlagFeedback();
         Snackbar.make(getView(),"Choose Your Course To Give Feedback ",Snackbar.LENGTH_SHORT).show();
    }
     Boolean feedbackBoolean;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        userCourses = new CourseData();
        userCourses.getUserCoursesByBidList(progressBar,getView() , gettingTypeFromBundle());
        super.onStart();


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       feedbackBoolean = false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mycourse_user_ui, container, false);
        ButterKnife.bind (this , view);
        if(!gettingTypeFromBundle().equals("falseAdmin") )
        {
            title.setText("Choose a Course");

        }         return view ;
    }
    public String gettingTypeFromBundle ()
    {
        Bundle bundle = this.getArguments() ;
        return bundle.getString("type");
    }

}
