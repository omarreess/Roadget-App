package com.omaressam.rode.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.omaressam.rode.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class logoUI extends Fragment {
    @BindView(R.id.splash_logo)
ImageView logo ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view =  inflater.inflate(R.layout.fragment_logo_ui, container, false);
        ButterKnife.bind(this , view ) ;
        int SPLASH_TIME = 3000 ;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                        .addSharedElement(logo, "logoTranslate")

                         .build();

               Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_logoUI_to_loginUI  , null, null, extras );
             }
        }, 3000);

        return view ;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
}
