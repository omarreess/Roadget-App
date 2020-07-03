package com.omaressam.rode.NetworkLayer.Authentication;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signin {
    UserData userData = new UserData();

    public void LoginUser(ProgressBar progressBar , View view , String email , String password)
    {     progressBar.setVisibility(View.VISIBLE);
        if (ValidFormMail(view , email , password))
        {                                //pogress visible

            LoginFB(progressBar  , view , email , password);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);

        }

    }
    private void LoginFB (ProgressBar progressBar , View view , String email , String password)
    {  FirebaseAuth mAuth  = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) view.getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                               userData.getUserFB(progressBar , view , user.getUid());


                        } else {
                                         //pogress invisible
                             Toast.makeText(view.getContext(), "Wrong Password or Email",
                                    Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);

                        }

                        // ...
                    }
                });
    }

    private boolean ValidFormMail(View view, String email , String password) {

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(view.getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(view.getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 6) {
            Toast.makeText(view.getContext(), "Entre valid password", Toast.LENGTH_SHORT).show();
            return false; }

        return true;
    }

    public  void LogoutUser()
    {
          FirebaseAuth mAuth = FirebaseAuth.getInstance();
           mAuth.signOut();
    }
}
