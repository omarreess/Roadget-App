package com.example.rode.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.rode.Logic.matrielArrayAdapter;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PostFeedBackUI extends Fragment {
    @BindView(R.id.feedback_review)
    EditText review;
    @BindView(R.id.feedback_course)
   TextView course ;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;



      @OnClick(R.id.feedback_post)
    public void postFeedback() {
              getBundle();

         UserData userData = new UserData();
         userData.setUserCoursesFeedback(bid , UserData.user.getId(),review.getText().toString(),((int) ratingBar.getRating()));
          Snackbar.make(getView(),"Posted ",Snackbar.LENGTH_LONG).show();

          Navigation.findNavController(Objects.requireNonNull(getView())).navigateUp();


     }
    String title ;
    int bid ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_post_feedback_ui, container, false);
        ButterKnife.bind(this, view);
        course.setText(title);

        return view;
    }

    public void  getBundle ()
    {    // getting course id for request of it
        Bundle bundle = this.getArguments();
          bid = bundle.getInt("id");
          title = bundle.getString("title");



    }
     }

