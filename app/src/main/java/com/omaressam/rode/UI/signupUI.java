package com.omaressam.rode.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.omaressam.rode.NetworkLayer.Authentication.Signup;
import com.omaressam.rode.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class signupUI extends Fragment {
    @BindView(R.id.signup_btn)
    Button signupBtn;
    @BindView(R.id.signup_haveacc)
    TextView haveAcc;
    Boolean showPasswordBoolean = true;
    @BindView(R.id.signup_eye_password)
    ImageView showPassword ;
    //data
    @BindView(R.id.signup_adress)
    EditText address;
    @BindView(R.id.signup_email)
    EditText email;
    @BindView(R.id.signup_mob)
    EditText mobno;
    @BindView(R.id.signup_fullname)
    EditText name;
    @BindView(R.id.signup_username)
    EditText username;
    @BindView(R.id.signup_pass)
    EditText password;
    @BindView(R.id.signup_gender_spinner)
    Spinner type;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_signup_ui, container, false);
        ButterKnife.bind(this , view);
        return view;

    }

    @OnClick(R.id.signup_eye_password)
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
    //
    @OnClick(R.id.signup_btn)
    public void signup() {
         //progress visible
        Signup signup = new Signup();
        signup.createAcc(getContext() , getView() ,username.getText().toString() ,password.getText().toString(),email.getText().toString() , mobno.getText().toString() ,name.getText().toString(), address.getText().toString() , type.getSelectedItem().toString());}

    @OnClick(R.id.signup_haveacc)
    public void toLoginUI() {

        Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_signupUI_to_loginUI );
    }
 }
