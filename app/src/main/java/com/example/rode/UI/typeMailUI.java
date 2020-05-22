package com.example.rode.UI;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rode.NetworkLayer.Authentication.ForgetPassword;
import com.example.rode.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class typeMailUI extends Fragment {
    @BindView(R.id.type_mail_btn)
    Button sendCodeBtn;
    @BindView(R.id.type_mail_mail)
    EditText mail;
    @BindView(R.id.type_mail_back_textview)
    TextView back;
    @OnClick(R.id.type_mail_back_textview)
    public void returnBack ()
    {
        Navigation.findNavController(Objects.requireNonNull(getView())).navigateUp();

    }
    @OnClick(R.id.type_mail_btn)
    public void ResestPass() {
        ForgetPassword forgetPassword = new ForgetPassword();
        forgetPassword.ResetPass(getView() , mail.getText().toString());    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_type_mail_u_i, container, false);
        ButterKnife.bind(this , view);

        return view ;

    }
}
