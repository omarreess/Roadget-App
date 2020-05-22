package com.example.rode.NetworkLayer.Authentication;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.example.rode.Data.User;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Signup {
    UserData user = new UserData();
    public void createAcc (Context context  , View view ,  String username, String password, String email, String mobNo , String name , String address , String type)
    {                                //progress bar visible

        if(ValidFormSignup( context , username,  password, email, mobNo , name ,  address ,  type))
                       {
                           setUserData(  username,  password, email, mobNo , name ,  address ,  type);
                           NewAcc( context , view , email , password);
                       }
        else {
            //progress bar invisible

        }

    }

    private void  setUserData ( String username, String password,String email,String mobNo ,String name , String address , String type)
    {
        UserData.user = new User();
        UserData.user.setUsername(username);
        UserData.user.setPassword(password);
        UserData.user.setMail(email);
        UserData.user.setMobno(mobNo);
        UserData.user.setFullname(name);
        UserData.user.setAddress(address);
        UserData.user.setType(type);


    }

    private boolean ValidFormSignup(Context context , String username, String password,String email,String mobNo ,String name , String address , String type ) {
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(context.getApplicationContext(), "Enter Username!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context.getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.length() < 6) {
            Toast.makeText(context.getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(mobNo)) {
            Toast.makeText(context.getApplicationContext(), "Enter Mobile Number!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(context.getApplicationContext(), "Enter Your Name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context.getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(address)) {
            Toast.makeText(context.getApplicationContext(), "Enter Your Address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (type.equals("User Type")) {
            Toast.makeText(context.getApplicationContext(), "Choose The User Type!", Toast.LENGTH_SHORT).show();
            return false;
        }



        return true;
    }
   private void NewAcc (Context context  , View view, String email , String password)
     {
           FirebaseAuth mAuth = FirebaseAuth.getInstance();
           mAuth.createUserWithEmailAndPassword(email , password) .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if (task.isSuccessful()) {
                       // Sign in success, update UI with the signed-in user's information
                       FirebaseUser userAcc = mAuth.getCurrentUser();
                       Toast.makeText(context, "Account Created ", Toast.LENGTH_SHORT).show();
                       user.initializeFB(userAcc.getUid());
                        checkUserAdmin(view , UserData.user.getType());
                       //pass fragment form here
                   }
                   else {
                       Toast.makeText(context, "Entre a valid Email !", Toast.LENGTH_SHORT).show();
                   }

               }
           });


     }




    private void checkUserAdmin (View view, String type){
        if (type.equals("User"))
        {
            Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_signupUI_to_fieldsUI );
        }
        else {
            Navigation.findNavController(Objects.requireNonNull(view)).navigate(R.id.action_signupUI_to_profileAdminUI );
        }
    }
}
