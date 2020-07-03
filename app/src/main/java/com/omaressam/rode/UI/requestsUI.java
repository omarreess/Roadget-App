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

import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData;
import com.omaressam.rode.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class requestsUI extends Fragment {
    @BindView(R.id.admin_requests_list)
    RecyclerView recyclerView;
    @BindView(R.id.requests_course_title)
    TextView titleCourse;


    @BindView(R.id.progressBar)
    ProgressBar progressBar;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        UserData userData = new UserData();
        userData.getUserRequests( progressBar , getView() , getBundleId());
        super.onStart();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_requests_ui, container, false);
        ButterKnife.bind(this, view);
        progressBar.setVisibility(View.INVISIBLE);
        titleCourse.setText(getBundleTitle() + " course");
         return view ;
     }
public int  getBundleId ()
{    // getting course id for request of it
    Bundle bundle = this.getArguments();
    return bundle.getInt("id");

}
    public String   getBundleTitle()
    {    // getting course title for request of it
        Bundle bundle = this.getArguments();
        return bundle.getString("title");

    }
}
