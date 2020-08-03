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
import com.omaressam.rode.NetworkLayer.DatabaseFB.IdCounter
import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData
import com.omaressam.rode.R
import kotlinx.android.synthetic.main.fragment_login_ui.*
import kotlinx.android.synthetic.main.fragment_profile_admin_ui.*
import java.sql.Types
import java.util.*

class profileAdminUI : Fragment() {






   // @OnClick(R.id.profile_admin_logout)
    fun logoutBtn() {
        val signin = Signin()
        signin.LogoutUser()
        cleaningVars()
        clearKeepLoginFlag()
        Navigation.findNavController(view!!).navigate(R.id.action_profileAdminUI_to_loginUI)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getting admin courses
        val userData = UserData()
        userData.getUserCoursesBidFB()


        // get ids from FB
        val ids = IdCounter()
        ids.getIDs()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_admin_ui, container, false)

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        profile_admin_back.visibility = View.INVISIBLE
        //set user data
        profile_admin_name.text = UserData.user.fullname
        profile_admin_mail.text = UserData.user.mail

        profile_admin_requests.setOnClickListener {   requests()        }
        profile_admin_logout.setOnClickListener{logoutBtn()}
        profile_admin_mycourse.setOnClickListener{mycourse()}
        profile_admin_notes.setOnClickListener{notes()}
        profile_admin_matriel.setOnClickListener{matriel()}

    }



   // @OnClick(R.id.profile_admin_requests)
    fun requests() {
        val bundle = Bundle()
        bundle.putString("type", "reqAdmin")
        Navigation.findNavController(view!!).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI, bundle)
    }



    //@OnClick(R.id.profile_admin_mycourse)
    fun mycourse() {
        val bundle = Bundle()
        bundle.putString("type", "falseAdmin")
        Navigation.findNavController(view!!).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI, bundle)
    }



  //  @OnClick(R.id.profile_admin_notes)
    fun notes() {
        val bundle = Bundle()
        bundle.putString("type", "notesAdmin")
        Navigation.findNavController(view!!).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI, bundle)
    }



  //  @OnClick(R.id.profile_admin_matriel)
    fun matriel() {
        val bundle = Bundle()
        bundle.putString("type", "matrielAdmin")
        Navigation.findNavController(view!!).navigate(R.id.action_profileAdminUI_to_mycoursesAdminUI, bundle)
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