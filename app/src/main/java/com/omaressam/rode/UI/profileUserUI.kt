package com.omaressam.rode.UI

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.omaressam.rode.Data.Course
import com.omaressam.rode.Data.User
import com.omaressam.rode.Logic.coursesArrayAdapter
import com.omaressam.rode.Logic.myCourseArrayAdapter
import com.omaressam.rode.Logic.requestsArrayAdapter
import com.omaressam.rode.NetworkLayer.Authentication.Signin
import com.omaressam.rode.NetworkLayer.DatabaseFB.CourseData
import com.omaressam.rode.NetworkLayer.DatabaseFB.DashBoardData
import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData
import com.omaressam.rode.R
import kotlinx.android.synthetic.main.fragment_profile_admin_ui.*
import kotlinx.android.synthetic.main.fragment_profile_user_ui.*
import java.sql.Types
import java.util.*

class profileUserUI : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile_user_ui, container, false)

        return view
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //set user data
        profile_user_name.text = UserData.user.fullname
        profile_user_mail.text = UserData.user.mail

        profile_user_logout.setOnClickListener {   logoutBtn()        }
        profile_user_back.setOnClickListener{returnBack()}
        profile_user_mycourse.setOnClickListener{mycourse()}
        profile_user_matriel.setOnClickListener{matriel()}
        profile_user_notes.setOnClickListener{notes()}
    }

   // @OnClick(R.id.profile_user_logout)
    fun logoutBtn() {
        val signin = Signin()
        signin.LogoutUser()
        cleaningVars()
        clearKeepLoginFlag()
        Navigation.findNavController(view!!).navigate(R.id.action_profileUserUI_to_loginUI)
    }

    //@OnClick(R.id.profile_user_back)
    fun returnBack() {
        Navigation.findNavController(Objects.requireNonNull(view)!!).navigateUp()
    }


    //@OnClick(R.id.profile_user_mycourse)
    fun mycourse() {
        val bundle = Bundle()
        bundle.putString("type", "falseAdmin")
        Navigation.findNavController(view!!).navigate(R.id.action_profileUserUI_to_mycourseUserUI, bundle)
    }



   // @OnClick(R.id.profile_user_notes)
    fun notes() {
        val bundle = Bundle()
        bundle.putString("type", "notesUser")
        Navigation.findNavController(view!!).navigate(R.id.action_profileUserUI_to_mycourseUserUI, bundle)
    }



    //@OnClick(R.id.profile_user_matriel)
    fun matriel() {
        val bundle = Bundle()
        bundle.putString("type", "matrielUser")
        Navigation.findNavController(view!!).navigate(R.id.action_profileUserUI_to_mycourseUserUI, bundle)
    }

    fun cleaningVars() {
        coursesArrayAdapter.itemList = ArrayList()
        myCourseArrayAdapter.itemList = ArrayList()
        requestsArrayAdapter.requestsList = ArrayList()
        requestsArrayAdapter.courseId = Types.NULL
        CourseData.course = Course()
        DashBoardData.notesLists = ArrayList()
        DashBoardData.matrielLists = ArrayList()
        UserData.user = User()
        UserData.userCoursesBid = ArrayList()
    }
    fun clearKeepLoginFlag()
    {
        val sharedPreferences: SharedPreferences = this.activity!!.getSharedPreferences("intro,keeplogin" , Context.MODE_PRIVATE )

        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putBoolean("keep me" , false)
        editor.apply()
        editor.commit()
    }
}