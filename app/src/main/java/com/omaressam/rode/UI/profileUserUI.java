package com.omaressam.rode.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.omaressam.rode.Data.Course;
import com.omaressam.rode.Data.User;
import com.omaressam.rode.Data.UserCourses;
import com.omaressam.rode.Logic.coursesArrayAdapter;
import com.omaressam.rode.Logic.myCourseArrayAdapter;
import com.omaressam.rode.Logic.requestsArrayAdapter;
import com.omaressam.rode.NetworkLayer.Authentication.Signin;
import com.omaressam.rode.NetworkLayer.DatabaseFB.CourseData;
import com.omaressam.rode.NetworkLayer.DatabaseFB.DashBoardData;
import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData;
import com.omaressam.rode.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.sql.Types.NULL;


public class profileUserUI extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =    inflater.inflate(R.layout.fragment_profile_user_ui, container, false);
        ButterKnife.bind(this,view);
        //set user data
        userName .setText(UserData.user.getFullname());
        userMail .setText(UserData.user.getMail());

        return view ;
    }
    @BindView(R.id.profile_user_back)
    ImageView back;
    @BindView(R.id.profile_user_name)
    TextView userName;
    @BindView(R.id.profile_user_mail)
    TextView userMail;
    @BindView(R.id.profile_user_logout)
    Button logout;
    @OnClick (R.id.profile_user_logout)
    public void logoutBtn()
    {
        Signin signin = new Signin();
        signin.LogoutUser();
        cleaningVars();

        Navigation.findNavController(getView()).navigate(R.id.action_profileUserUI_to_loginUI );


    }
    @OnClick(R.id.profile_user_back)
    public void returnBack() {

        Navigation.findNavController(Objects.requireNonNull(getView())).navigateUp();
    }



    @BindView(R.id.profile_user_mycourse)
    Button mycourse;
    @OnClick(R.id.profile_user_mycourse)
    public void mycourse() {

        Bundle bundle = new Bundle();
        bundle.putString("type","falseAdmin");
        Navigation.findNavController(getView()).navigate(R.id.action_profileUserUI_to_mycourseUserUI , bundle);      }
    @BindView(R.id.profile_user_notes)
    Button notes;
    @OnClick(R.id.profile_user_notes)
    public void notes() {

        Bundle bundle = new Bundle();
        bundle.putString("type","notesUser");
        Navigation.findNavController(getView()).navigate(R.id.action_profileUserUI_to_mycourseUserUI , bundle);      }
    @BindView(R.id.profile_user_matriel)
    Button matriel;
    @OnClick(R.id.profile_user_matriel)
    public void matriel() {

        Bundle bundle = new Bundle();
        bundle.putString("type","matrielUser");
        Navigation.findNavController(getView()).navigate(R.id.action_profileUserUI_to_mycourseUserUI , bundle);      }

        public  void cleaningVars()
        {
            coursesArrayAdapter.itemList = new ArrayList<Course>();

            myCourseArrayAdapter.itemList = new ArrayList<Course>();
            requestsArrayAdapter.requestsList = new ArrayList<User>();
            requestsArrayAdapter.courseId= NULL;
            CourseData.course = new Course();
            DashBoardData.notesLists = new ArrayList<>();
            DashBoardData.matrielLists = new ArrayList<>();
            UserData.user=new User();
            UserData.userCoursesBid = new ArrayList<UserCourses>();
        }
}
