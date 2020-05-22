package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class androidRoadMap {
    private String[] androidRoad = {  "Introduction to Java and Android", "Android Stack Introduction ", "Installing Android and creating first app on emulator", "Android Architecture and building blocks", "Android App build process", "Java overview– Data types, Loops, Conditionals and Operators", "Android UI– resources, themes, threads ",
            "Debugging in android", "Assignments on Java Classes, Objects, Methods, Instances  ", "Activities , Receivers, Adapters and Providers", "Telephony System Architecture of Android", "Systems Programming and JNI Concepts", "Introduction to System programming in Android", "Java interface", "Native library implementation", "Building the sample native library", "Using native functions in Java code", "Security and Permissions", "Android Graphics and Multimedia", "Basic Graphics - Input Handling","Accessing Files system, SD Cards", "SQLite overview, Data Binding, Content Provider", "Assignments and exposure to Lab infrastructure ", "UI design aspects of Apps",  "Gestures/touch/click handling ",  "Instantiate UI elements at runtime ",  "Views and Interacting with views",
            "3D graphics in OpenGL and Android Widget", "OpenGL Introduction", "Using Threads and Models", "Texture in OpenGL", "Making a application in OpenGL", "Other standard views in Android", "Android Widget Development", "Android Networking", "Accessing the Internet", "Using Web services", "Using Java and Java Script", "Location Sensing", "Client Server Programming", "Working with XML/JSON", "Complete App Development", "Developing live App and modules"
            , "Developing custom launchers and skins", "Full software lifecycle exposure from requirement to  market launch.", "Applications utilizing location and maps" };

    public ArrayList<String> getAndroidRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(androidRoad);
    }


        public String Reference  ="siliconindia.com/online_university/Android/Course_Content.html ";
}
