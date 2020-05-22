package com.example.rode.UI;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rode.NetworkLayer.DatabaseFB.UserData;
import com.example.rode.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class courseDetailsUI extends Fragment {
    String aid ;
    int bid ;
    @BindView(R.id.course_details_description)
    TextView courseDescrip;
    @BindView(R.id.details_course_date)
    TextView courseDate;
    @BindView(R.id.details_course_instructor)
    TextView courseInstructor;

    @BindView(R.id.details_course_location)
    TextView courseLocation;
    @BindView(R.id.details_course_name)
    TextView courseName;
    @BindView(R.id.details_course_pay)
    Button payBtn;
    @BindView(R.id.course_details_back)
    ImageView backBtn;
    @BindView(R.id.details_course_place)
    TextView coursePlace;
    @BindView(R.id.details_course_rate)
    TextView courseRate;
    @BindView(R.id.details_course_rode_rate)
    TextView rodeRate;
    @BindView(R.id.details_course_price)
    TextView coursePrice;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        courseDescrip.setMovementMethod(new ScrollingMovementMethod());


        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_details_ui, container, false);
        ButterKnife.bind(this, view);
         getBundle();


        return view;
    }

    @OnClick(R.id.course_details_back)
    public void returnBack() {

        Navigation.findNavController(Objects.requireNonNull(getView())).navigateUp();
    }

    @OnClick(R.id.details_course_pay)
    public void pay() {
                              alertDiaolge();

    }

    public void alertDiaolge()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage("Are you sure to payrol ?");
        builder1.setCancelable(true);


        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                         dialog.cancel();
                        UserData userData = new UserData();
                        userData.setUserRequest(bid , UserData.user.getId() );
                        Snackbar.make(getView(),"Your Request is under approval ",Snackbar.LENGTH_LONG).show();

                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                         dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
        alert11.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.green));
        alert11.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.black));

    }
    void getBundle(){
        Bundle bundle = this.getArguments();
        aid = bundle.getString("aid");
        bid = bundle.getInt("bid");

        courseDescrip.setText(bundle.getString("disc"));
        courseInstructor.setText(bundle.getString("instructor"));
        courseLocation.setText(bundle.getString("location"));
        coursePlace.setText(bundle.getString("placename"));
        rodeRate.setText(bundle.getString("roadrate"));
        courseRate.setText(bundle.getString("rate"));
        coursePrice.setText(bundle.getString("price"));
        courseDate.setText(bundle.getString("date"));

    }

}
