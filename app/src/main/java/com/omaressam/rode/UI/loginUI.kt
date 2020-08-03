package com.omaressam.rode.UI

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.omaressam.rode.NetworkLayer.Authentication.Signin
import com.omaressam.rode.R
import kotlinx.android.synthetic.main.fragment_login_ui.*
import java.util.*

class loginUI : Fragment() {





    var showPasswordBoolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login_ui, container, false)
         val transition = TransitionInflater.from(context)
                .inflateTransition(R.transition.logotranslate)
        sharedElementEnterTransition = transition
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        checkKeepMe()

        login_loginbtn.setOnClickListener {   toFieldFramgnet()        }
        login_create.setOnClickListener{toCreateAcc()}
        login_forget.setOnClickListener{toVerifyPass()}
        login_eye_password.setOnClickListener{showPassword()}
      }

    //@OnClick(R.id.login_eye_password)
    fun showPassword() {
        if (showPasswordBoolean) {
            // Show Password
            login_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            showPasswordBoolean = false
        } else {
            // Hide Password
            login_password.transformationMethod = PasswordTransformationMethod.getInstance()
            showPasswordBoolean = true
        }
    }

    // @OnClick(R.id.login_loginbtn)
    fun toFieldFramgnet() {
        // check if user or admin to navigate to correct place
        //progress visible
        val signin = Signin()
        signin.LoginUser(progressBar, view, login_username.text.toString(), login_password.text.toString())
        //check checkbox
        if(checkBox.isChecked)
        {markKeepMe()}
    }

   // @OnClick(R.id.login_forget)
    fun toVerifyPass() {
        Navigation.findNavController(Objects.requireNonNull(view)!!).navigate(R.id.action_loginUI_to_typeMailUI)
    }

    //@OnClick(R.id.login_create)
    fun toCreateAcc() {
        Navigation.findNavController(Objects.requireNonNull(view)!!).navigate(R.id.action_loginUI_to_signupUI)
    }

    fun markKeepMe()
    { val sharedPreferences: SharedPreferences = this.context!!.getSharedPreferences("intro,keeplogin" , Context.MODE_PRIVATE )
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()

         editor.putBoolean("keep me" , true)
        editor.putString("mail" , login_username.text.toString())
        editor.putString("pass" , login_password.text.toString())
        editor.apply()
        editor.commit()

    }
    fun checkKeepMe() {
        progressBar.visibility=View.VISIBLE

        val sharedPreferences: SharedPreferences = this.context!!.getSharedPreferences("intro,keeplogin" , Context.MODE_PRIVATE )

          if(sharedPreferences.getBoolean("keep me" , false))
          {   val savedMail = sharedPreferences.getString("mail" , null)
             val savedPass = sharedPreferences.getString("pass" , null)
              val signin = Signin()
              signin.LoginUser(progressBar, view, savedMail, savedPass)
          }
        else
          {        progressBar.visibility=View.INVISIBLE
          }


    }
}