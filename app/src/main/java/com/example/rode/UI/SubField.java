package com.example.rode.UI;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rode.Data.Fields;
import com.example.rode.Logic.fieldsArrayAdapter;
import com.example.rode.Logic.subFieldsArrayAdapter;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubField extends Fragment {
    @BindView(R.id.subfields_list)
    RecyclerView recyclerView;

    @BindView(R.id.subfield_title)
    TextView subFieldTitle;
    String currentSubField;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @BindView(R.id.subfield_profile)
    ImageView profile;
    @OnClick(R.id.subfield_profile)
    public void toprofile() {

 checkUserAdmin(UserData.user.getType());    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_field, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = this.getArguments();


        currentSubField = bundle.getString("field");
         subFieldTitle.setText(currentSubField);
        listForFields();
        return view;    }
    public void listForFields()
    {
        //Bundle bundle = this.getArguments();

        Fields fields = new Fields();
         ArrayList<String> subFieldsList = fields.checkSubField(        currentSubField);


        subFieldsArrayAdapter   fieldsArrayAdapter = new subFieldsArrayAdapter(R.layout.item_field_sub, subFieldsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(fieldsArrayAdapter);
    }
    @OnClick(R.id.subfield_back)
    public void returnBack() {

        Navigation.findNavController(Objects.requireNonNull(getView())).navigateUp();
    }

    public void checkUserAdmin (String type){
        if (type.equals("User"))
        {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_subField_to_profileUserUI );
        }
        else {
            Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_subField_to_profileAdminUI );
        }
    }
}
