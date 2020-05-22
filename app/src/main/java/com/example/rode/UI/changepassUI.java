package com.example.rode.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.broooapps.otpedittext2.OtpEditText;
import com.example.rode.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class changepassUI extends Fragment {
    @BindView(R.id.changepass_pass)
    EditText pass;
    @BindView(R.id.changepass_repass)
     EditText rePass;
    @OnClick(R.id.changepass_btn)
    public void changePass() {
        if (pass.getText().toString().equals(rePass.getText().toString()))
        {
            Toast.makeText(getContext(), "Password Changed ", Toast.LENGTH_SHORT).show();
            //check if user or admin
            checkUserAdmin("admin");}
        else{
//            Toast.makeText(getContext(), " Passwords Not Matched  ", Toast.LENGTH_SHORT).show();

            Toast.makeText(getContext(), pass.getText()+""+rePass.getText(), Toast.LENGTH_SHORT).show();

        }



    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_changepass_ui, container, false);
        ButterKnife.bind(this,view);
        return view;

    }
    public void checkUserAdmin (String type){
        if (type.equals("user"))
        {

            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_changepassUI_to_fieldsUI );


        }
        else {

            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_changepassUI_to_profileAdminUI );

        }
    }
}
