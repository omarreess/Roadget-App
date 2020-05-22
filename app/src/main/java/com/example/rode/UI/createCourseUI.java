package com.example.rode.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rode.Data.Fields;
import com.example.rode.NetworkLayer.DatabaseFB.CourseData;
import com.example.rode.NetworkLayer.DatabaseFB.IdCounter;
import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;


public class createCourseUI extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @BindView(R.id.create_course_address)
    EditText location;
    @BindView(R.id.create_course_name)
    EditText courseName;
    @BindView(R.id.create_course_place)
    EditText placeName;
    @BindView(R.id.create_course_descrption)
    EditText descreption;
    @BindView(R.id.create_course_date)
    EditText date;
    @BindView(R.id.create_course_price)
    EditText price;
    @BindView(R.id.create_course_instructor)
    EditText instructor;
    @BindView(R.id.create_course_field_spinner)
    Spinner field;
    @BindView(R.id.create_course_subfield_spinner)
    Spinner subField;
    @BindView(R.id.create_course_btn)
    Button createCourseBtn;
    @OnClick (R.id.create_course_btn)
    public void createCourse()
    {
       // Toast.makeText(getContext(), UserData.user.getId(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(),""+ CourseData.course.getId(), Toast.LENGTH_SHORT).show();

        CourseData courseData = new CourseData();
         courseData.CreateCourse( getView() ,UserData.user.getId() ,courseName.getText().toString() , placeName.getText().toString() , instructor.getText().toString() , Integer.parseInt(price.getText().toString()), date.getText().toString() , descreption.getText().toString() ,location.getText().toString() , subField.getSelectedItem().toString() , field.getSelectedItem().toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_create_course_ui, container, false);
        ButterKnife.bind(this, view);

        //add list to spinner
        spinnerFieldList();
        return view;
    }

@OnItemSelected(R.id.create_course_field_spinner)
public void  fieldSpinner ()
{
    spinnerSubFieldList(field.getSelectedItem().toString());
}
    public void spinnerFieldList()
    {
        Fields fields = new Fields();
        ArrayList<String> fieldArr = fields.getFieldsTittles();
         ArrayAdapter fieldAdapter = new ArrayAdapter(Objects.requireNonNull(getContext()),android.R.layout.simple_spinner_item,fieldArr);
        field.setAdapter(fieldAdapter);


    }
    public void spinnerSubFieldList(String currentfield)
    {
        Fields fields = new Fields();
        ArrayList<String> subFieldsList = fields.checkSubField(        currentfield);

        ArrayAdapter subFieldAdapter = new ArrayAdapter(this.getContext(),android.R.layout.simple_spinner_item,subFieldsList);

         subField.setAdapter(subFieldAdapter);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {

        super.onResume();
    }


}
