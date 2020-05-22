package com.example.rode.UI;

import android.app.ActivityOptions;
import android.app.SharedElementCallback;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.Navigation;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rode.NetworkLayer.Authentication.Signin;
import com.example.rode.NetworkLayer.DatabaseFB.IdCounter;
import com.example.rode.R;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class loginUI extends Fragment {
    @BindView(R.id.login_logo)
    ImageView logo ;
    @BindView(R.id.progressBar)
    ProgressBar progressbar ;
    @BindView(R.id.login_eye_password)
    ImageView showPassword ;
    @BindView(R.id.login_loginbtn)
    Button loginBtn;
    @BindView(R.id.login_create)
    TextView createAcc;
    @BindView(R.id.login_forget)
    TextView forgetPass;
    @BindView(R.id.login_password)
    EditText password;
    @BindView(R.id.login_username)
    EditText username;
    Boolean showPasswordBoolean = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

                View view = inflater.inflate(R.layout.fragment_login_ui, container, false);
        ButterKnife.bind(this, view);
        Transition transition =
                TransitionInflater.from(getContext())
                        .inflateTransition(R.transition.logotranslate);
        setSharedElementEnterTransition(transition);
         return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Check keep melogin
progressbar.setVisibility(View.INVISIBLE);
         checkKeepMe();
    }
    @OnClick(R.id.login_eye_password)
    public void showPassword() {
        if (showPasswordBoolean)
        {
            // Show Password
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            showPasswordBoolean= false;
        }
        else
        {
            // Hide Password
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            showPasswordBoolean = true;
        }

    }
    @OnClick(R.id.login_loginbtn)
    public void toFieldFramgnet() {
        // check if user or admin to navigate to correct place
        //progress visible
        Signin signin = new Signin();
        signin.LoginUser(progressbar , getView(), username.getText().toString() , password.getText().toString());
           }

    @OnClick(R.id.login_forget)
    public void toVerifyPass() {

         Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_loginUI_to_typeMailUI );
    }
    @OnClick(R.id.login_create)
    public void toCreateAcc() {
        Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_loginUI_to_signupUI );
    }
    public void checkKeepMe(){
        //check if exist sharedpref
        if(FALSE)
        {
            checkUserAdmin("user");
        }

    }
    public void checkUserAdmin (String type){
        if (type.equals("user"))
        {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_loginUI_to_fieldsUI );
        }
        else {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_loginUI_to_profileAdminUI );
        }
    }
}
