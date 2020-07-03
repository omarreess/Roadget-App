package com.omaressam.rode.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.omaressam.rode.NetworkLayer.DatabaseFB.DashBoardData;
import com.omaressam.rode.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class materialUserUI extends Fragment {
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
DashBoardData dashBoardData ;
    @BindView(R.id.user_matriel_list)
    RecyclerView recyclerView;
    @BindView(R.id.user_matriel_course_title)
    TextView courseTitle;


    @Override
    public void onStart() {
        dashBoardData.getMatrielDashboard(progressBar , getView() , recyclerView , getBundleandId());

        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dashBoardData = new DashBoardData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_material_user_ui, container, false);

        ButterKnife.bind(this, view);
         return view;
    }

    public int  getBundleandId ()
    {    // getting course id for request of it
        Bundle bundle = this.getArguments();
        return bundle.getInt("id");

    }

}
