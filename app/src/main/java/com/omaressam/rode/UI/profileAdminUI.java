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
import com.omaressam.rode.NetworkLayer.DatabaseFB.IdCounter;
import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData;
import com.omaressam.rode.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.sql.Types.NULL;


public class profileAdminUI extends Fragment {
    @BindView(R.id.profile_admin_logout)
    Button logout;
    @BindView(R.id.profile_admin_name)
    TextView userName;
    @BindView(R.id.profile_admin_mail)
    TextView userMail;
    @OnClick (R.id.profile_admin_logout)
    public void logoutBtn()
    {
         Signin signin = new Signin();
        signin.LogoutUser();
         cleaningVars();

        Navigation.findNavController(getView()).navigate(R.id.action_profileAdminUI_to_loginUI );

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getting admin courses
        UserData userData = new UserData();
        userData.getUserCoursesBidFB();



        // get ids from FB
        IdCounter ids = new IdCounter();
        ids.getIDs();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view =   inflater.inflate(R.layout.fragment_profile_admin_ui, container, false);
        ButterKnife.bind(this,view );
        back.setVisibility(View.INVISIBLE);
        //set user data
        userName .setText(UserData.user.getFullname());
        userMail .setText(UserData.user.getMail());
        return view ;
    }

    @BindView(R.id.profile_admin_back)
    ImageView back;

    @BindView(R.id.profile_admin_requests)
    Button request;
    @OnClick(R.id.profile_admin_requests)
    public void requests() {
Bundle bundle = new Bundle();
bundle.putString("type","reqAdmin");
        Navigation.findNavController(getView()).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI , bundle);    }

    @BindView(R.id.profile_admin_mycourse)
    Button mycourse;
    @OnClick(R.id.profile_admin_mycourse)
    public void mycourse() {

        Bundle bundle = new Bundle();
        bundle.putString("type","falseAdmin");
        Navigation.findNavController(getView()).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI , bundle);      }
        @BindView(R.id.profile_admin_notes)
    Button notes;
    @OnClick(R.id.profile_admin_notes)
    public void notes() {

        Bundle bundle = new Bundle();
        bundle.putString("type","notesAdmin");
        Navigation.findNavController(getView()).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI , bundle);      }
        @BindView(R.id.profile_admin_matriel)
    Button matriel;
    @OnClick(R.id.profile_admin_matriel)
    public void matriel() {

        Bundle bundle = new Bundle();
        bundle.putString("type","matrielAdmin");
        Navigation.findNavController(getView()).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI , bundle);
       }
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
