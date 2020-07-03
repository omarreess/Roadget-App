package com.omaressam.rode.NetworkLayer.Authentication;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword {

public  void ResetPass(View view , String email)
{
   if(ValidFormMail(view , email)) {
       SendResetLink(view , email);
   }

}
    private boolean ValidFormMail(View view, String email) {

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(view.getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

 private void SendResetLink(View view , String email)
 {
     FirebaseAuth.getInstance().sendPasswordResetEmail(email)
             .addOnCompleteListener(new OnCompleteListener<Void>() {
                 @Override
                 public void onComplete(@NonNull Task<Void> task) {
                     if (task.isSuccessful()) {
                         Snackbar.make(view,"Check Your Mail ", Snackbar.LENGTH_LONG).show();
                     }
                     else {
                         Toast.makeText(view.getContext(), "Entre a valid Email", Toast.LENGTH_SHORT).show();
                     }
                 }
             });
 }
}
