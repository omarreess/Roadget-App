package com.example.rode.UI;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Toast;

import com.example.rode.Logic.matrielArrayAdapter;
import com.example.rode.NetworkLayer.DatabaseFB.DashBoardData;
import com.example.rode.NetworkLayer.DatabaseFB.IdCounter;
import com.example.rode.R;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MaterialAdminUI extends Fragment {
    DashBoardData dashBoardData ;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.user_mycourse_list)
    RecyclerView recyclerView;
    @BindView(R.id.admin_matriel_course_title)
    TextView courseTitle;
     matrielArrayAdapter matrielArrayAdapter;
    @OnClick(R.id.admin_mycourse_addcourse_img)
    public void addFile() {
        getFileAndUpload();

            }


    @Override
    public void onStart() {
        dashBoardData.getMatrielDashboard(progressBar , getView() , recyclerView , getBundleandId() );
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
         View view =inflater.inflate(R.layout.fragment_material_admin_ui, container, false);
        ButterKnife.bind(this, view);


        return view;
    }


    public void getFileAndUpload  () {
        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT );

        chooseFile.setType("*/*");
        chooseFile = Intent.createChooser(chooseFile, " Choose the file ");
        startActivityForResult(chooseFile, 1);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == -1) {
                    Uri fileUri = data.getData();
                    String name = "file "+IdCounter.dashboradMatrielID;
                    dashBoardData.setMatrielDashboard( getView() , getBundleandId() , fileUri ,name  );


                 }

                break;
        }
    }
    public int  getBundleandId ()
    {    // getting course id for request of it
        Bundle bundle = this.getArguments();
        return bundle.getInt("id");

    }
}
