package com.omaressam.rode.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.omaressam.rode.NetworkLayer.DatabaseFB.CourseData;
import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData;
import com.omaressam.rode.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class coursesUI extends Fragment {
    @BindView(R.id.courses_list)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressbar;
    @BindView(R.id.courses_profile)
    ImageView profile;


    @BindView(R.id.courses_back)
    ImageView back;
    @BindView(R.id.courses_subfield_title)
    TextView title;
    @OnClick(R.id.courses_profile)
    public void toprofile() {

 checkUserAdmin(UserData.user.getType());    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        //geting subfield from pervious fragment
        Bundle bundle = this.getArguments();
        CourseData courseData  = new CourseData(getView());
        courseData.getCoursesBySubField( progressbar,getView() , bundle.getString("subField"));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_courses_ui, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();

        title.setText(bundle.getString("subField"));

        return view;
     }




    @OnClick(R.id.courses_back)
    public void returnBack() {

        Navigation.findNavController(Objects.requireNonNull(getView())).navigateUp();
    }
    public void checkUserAdmin (String type){
        if (type.equals("User"))
        {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_coursesUI_to_profileUserUI );
        }
        else {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_coursesUI_to_profileAdminUI );
        }
    }
    //for spinner

}
