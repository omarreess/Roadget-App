package com.example.rode.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rode.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFeedbacksUI extends Fragment {

    public CourseFeedbacksUI() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_feedbacks_ui, container, false);
    }
}
