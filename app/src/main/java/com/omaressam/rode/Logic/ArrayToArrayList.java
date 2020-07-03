package com.omaressam.rode.Logic;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToArrayList {


    public ArrayList<String> convertArray (String[] array ) {



        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));
        ArrayList<String> arrayListCap = new ArrayList<>();
        for (int i =0 ; i < arrayList.size() ; i++)
        {
            arrayListCap.add(arrayList.get(i).substring(0, 1).toUpperCase() + arrayList.get(i).substring(1).toLowerCase());
        }

        return arrayListCap;   }




}
