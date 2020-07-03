package com.omaressam.rode.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.omaressam.rode.Data.Fields;
import com.omaressam.rode.Logic.fieldsArrayAdapter;
import com.omaressam.rode.NetworkLayer.DatabaseFB.IdCounter;
import com.omaressam.rode.NetworkLayer.DatabaseFB.UserData;
import com.omaressam.rode.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class fieldsUI extends Fragment {
    @BindView(R.id.fields_list) RecyclerView recyclerView;

    @BindView(R.id.fields_profile)
    ImageView profile;
    @BindView(R.id.fields_back)
    ImageView back;
    @OnClick(R.id.fields_profile)
    public void toprofile() {
         //check if  user or admin to navigate to correct place
        checkUserAdmin(UserData.user.getType());
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getting usercourses
        UserData userData = new UserData();
        userData.getUserCoursesBidFB();
        // get ids from FB
        IdCounter ids = new IdCounter();
        ids.getIDs();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fields_ui, container, false);
        ButterKnife.bind(this, view);
        back.setVisibility(View.INVISIBLE);
       listForFields();



        return view;
      }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    public void listForFields()
   {

       Fields fields = new Fields();
       ArrayList<String> fieldsList = fields.getFieldsTittles();


       fieldsArrayAdapter fieldsArrayAdapter = new fieldsArrayAdapter(R.layout.item_field_sub, fieldsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       recyclerView.setItemAnimator(new DefaultItemAnimator());
       recyclerView.setHasFixedSize(true);
       recyclerView.setAdapter(fieldsArrayAdapter);
   }
    public void checkUserAdmin (String type){
        if (type.equals("User"))
        {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_fieldsUI_to_profileUserUI );
        }
        else {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_fieldsUI_to_profileAdminUI );
        }
    }
}
