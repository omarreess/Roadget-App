package com.example.rode.Data;

import com.example.rode.Logic.ArrayToArrayList;

import java.util.ArrayList;

public class iosRoadMap {
    private String[] iosRoad = {  "Development Environment ",  "Xcode -Usage", "Creating sample application ", "Objective -c - Variables and constant", "Loops & Control statements", "Arrays and pointers", "Auto release pool & Managing memory", "Interface builder -Document window tool", "Outlets and actions", "Kinds of debugging",
            "Managing and controlling program execution flow", "Setting and viewing breakpoints and investigation", "Properties", "Protocols and Categories in", "Cocoa classes", "Basic Interaction", "Understanding MVC architecture", "Delegation", "Advance Controls in iphone",
            "Segmented Controls", "Views and view hierarchy",
            "Working with Gesture and swipe - UITouch  ","UI Responder", "Customizing input types", "Displaying, dismissing of keyboard", "Orientations of screen", "Property list types and objects", "Property list serialization",
            "Creating and modifying of data using pList", "File handling in iOS ",
            "Using SQLlite", "Persistence using property list", "Understanding the use of Accelerometer", "Url loading system", "Working on url loading system", "Using Address book, Maps, Safari, mail, and other standard applications", "Introduction To Objective-C", "int data type", "char data type", "float data type ", "double data type",
            "id data type", "Bool data type", "Objective c data type qualifiers“, “Using the if Statement", "Using if ... else if .. Statements", "double data type" };

    public ArrayList<String> getIosRoad() {
        ArrayToArrayList obj = new ArrayToArrayList();

        return obj.convertArray(iosRoad);
    }

         public   String References = "siliconindia.com/online_course/ios-cid-56.html ";

        }
