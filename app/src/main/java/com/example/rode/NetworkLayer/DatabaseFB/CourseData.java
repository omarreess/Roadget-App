package com.example.rode.NetworkLayer.DatabaseFB;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rode.Data.Course;
import com.example.rode.Data.User;
import com.example.rode.Data.UserCourses;
import com.example.rode.Logic.coursesArrayAdapter;
import com.example.rode.Logic.myCourseArrayAdapter;
import com.example.rode.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static android.view.View.*;

public class CourseData {
    public  ImageView sortImg ;
    public static Course course = new Course();
    myCourseArrayAdapter myCourseArrayAdapter;
    public void FlagFeedback()
    {
        myCourseArrayAdapter.addFeedback();
    }
    coursesArrayAdapter coursesArrayAdapter;
    public CourseData (View view)
    {
        sortImg = view.findViewById(R.id.course_sort);
         sortImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);

            }
        });
    }
    public CourseData(){}

    public void CreateCourse (View view , String AdminId , String courseName , String placeName , String instructor, int price, String date, String descreption, String location  , String subField , String field )
    {
        if (ValidFormCourse(view.getContext() ,courseName , placeName , instructor , price , date , descreption ,location , subField , field ))
        { course=setCourseLocall(AdminId ,courseName , placeName , instructor , price , date , descreption ,location , subField , field);
            setCourseFB(view);}

    }


    private Course  setCourseLocall( String AdminId ,String courseName , String placeName , String instructor, int price, String date, String descreption, String location  , String subField , String field)
    {
        Course courselocal = new Course(courseName , placeName , instructor , price , date , descreption ,location , subField , field);
        //to be sure that idcounter intliazed in mainUI
        courselocal.setAID(AdminId);
        courselocal.setRoadmapRate(50);

        courselocal.setId(IdCounter.courseID);
        return courselocal;
    }

    private void setCourseFB(View view)
    {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Course");
        myRef.child(course.getId()+"").setValue(course);
        //seting my user course fb
         UserData userData = new UserData();
         userData.setUserCoursesFB(CourseData.course.getId() , CourseData.course.getAID());
        IdCounter ids = new IdCounter();
        ids.setIncreamentCourseID(course.getId());
        Snackbar.make(view," New Course Added",Snackbar.LENGTH_LONG).show();
        Navigation.findNavController(view).navigate(R.id.action_createCourseUI_to_profileAdminUI);


    }
    private boolean ValidFormCourse(Context context ,String courseName , String placeName , String instructor, int price, String date, String descreption, String location  , String subField , String field  ) {
        if (TextUtils.isEmpty(courseName)) {
            Toast.makeText(context.getApplicationContext(), "Enter Course Name !", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(placeName)) {
            Toast.makeText(context.getApplicationContext(), "Enter Place Name !", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (TextUtils.isEmpty(instructor)) {
            Toast.makeText(context.getApplicationContext(), "Enter Instructor  Number!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty( Integer.toString(price))) {
            Toast.makeText(context.getApplicationContext(), "Enter Course Price !", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(date)) {
            Toast.makeText(context.getApplicationContext(), "Enter Course  Date !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(descreption)) {
            Toast.makeText(context.getApplicationContext(), "Enter Course Descreption!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(location)) {
            Toast.makeText(context.getApplicationContext(), "Enter Course Location!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (field.equals("Choose Field")) {
            Toast.makeText(context.getApplicationContext(), "Choose Course Field !", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (subField.equals("Choose Sub Field")) {
            Toast.makeText(context.getApplicationContext(), "Choose Course Sub Field !", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }


    public  void getCoursesBySubField(ProgressBar progressBar , View view  , String subfield)
    { progressBar.setVisibility(VISIBLE);
        RecyclerView recyclerView = view.findViewById(R.id.courses_list);
         //progress visible

        ArrayList<Course> courseList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Course");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                  for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    if(childDataSnapshot.child("subField").getValue(String.class) .equals(subfield))
                    {                    courseList.add(childDataSnapshot.getValue(Course.class));
                    }
                  }
                // adding list
                  coursesArrayAdapter = new coursesArrayAdapter(R.layout.item_course_list, courseList);
                 recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                  recyclerView.setItemAnimator(new DefaultItemAnimator());
                   recyclerView.setAdapter(coursesArrayAdapter);
                  progressBar.setVisibility(INVISIBLE);
              myRef.removeEventListener((ValueEventListener) this);

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }
    public  void getUserCoursesByBidList( ProgressBar progressBar ,  View view , String typeBundle )

    {
        progressBar.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = view.findViewById(R.id.user_mycourse_list);

        ArrayList<Course> courseList = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Course");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    // for getting only course that have same bid from arrray parameter

                    for (int i = 0; i < UserData.userCoursesBid.size(); i++) {
                        if (UserData.userCoursesBid.get(i).getBid() == childDataSnapshot.child("id").getValue(int.class))
                        {
                             courseList.add(childDataSnapshot.getValue(Course.class));
                        }
                     }
                     //seting the list
                      myCourseArrayAdapter = new myCourseArrayAdapter(R.layout.item_mycourse, courseList ,  typeBundle);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(myCourseArrayAdapter);
                    if(courseList.size()==0)
                    {
                        //Snackbar.make(view,"You not enrolled in any courses ",Snackbar.LENGTH_LONG).show();
                    }

                }
                progressBar.setVisibility(INVISIBLE);

                myRef.removeEventListener((ValueEventListener) this);

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }

    private void showPopup(View v) {
        PopupMenu popup = new PopupMenu(v.getContext(), v);
        popup.getMenuInflater().inflate(R.menu.sort, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getTitle().toString()) {
                    case "Highest Roadmap Rate":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            Collections.sort(coursesArrayAdapter.itemList, Comparator.comparing(Course::getRoadmapRate));
                            Collections.reverse(coursesArrayAdapter.itemList);

                            coursesArrayAdapter.notifyDataSetChanged();

                        }
                        return true;
                    case "Highest Feedback Rate":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            Collections.sort(coursesArrayAdapter.itemList, Comparator.comparing(Course::getRate));
Collections.reverse(coursesArrayAdapter.itemList);
                             coursesArrayAdapter.notifyDataSetChanged();

                        }
                        return true;
                    case "Price: Low to High":
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            Collections.sort(coursesArrayAdapter.itemList, Comparator.comparing(Course::getPrice));

                            coursesArrayAdapter.notifyDataSetChanged();

                        }
                        return true;
                    default:
                        return false;
                }
            }
        });

        popup.show();
    }

}
