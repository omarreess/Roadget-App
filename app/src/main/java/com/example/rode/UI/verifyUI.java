package com.example.rode.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.broooapps.otpedittext2.OnCompleteListener;
import com.broooapps.otpedittext2.OtpEditText;
import com.example.rode.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class verifyUI extends Fragment {

    @BindView(R.id.verify_code_again)
    TextView sendCodeAgain;
    @BindView(R.id.verify_passcode)
    OtpEditText passcode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
                View view = inflater.inflate(R.layout.fragment_verify_ui, container, false);
                ButterKnife.bind(this,view);
                passcode.setOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(String value) {
                        if (value.equals("555555"))
                        {
                            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_verifyUI_to_changepassUI );

                        }
                        else {
                            Toast.makeText(getContext(), "Wrong Code ", Toast.LENGTH_SHORT).show();
                            passcode.setText(null);
                        }
                    }
                });
        return view ;


    }

}
