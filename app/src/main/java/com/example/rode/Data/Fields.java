package com.example.rode.Data;

import java.util.ArrayList;

public class Fields {
    private ArrayList<String> fieldsTittles = new ArrayList<String>() {
        {
            add("Mobile Development");
            add("Web Development");
            add("Artificial Intelligence");
            add("Network");
            add("Security");
            add("Database");

        }
    };
    private ArrayList<String> aiSubfield = new ArrayList<String>() {
        {
            add("Machine learning engineer");
            add("Data scientist");
            add("Big data engineer");



        }
    };
    private ArrayList<String> securitySubField = new ArrayList<String>() {
        {

            add("Penetration testing");


        }
    };
    private ArrayList<String> mobDevSubField = new ArrayList<String>() {
        {
            add("Android development");
            add("Ios development");



        }
    };
    private ArrayList<String> networkSubField = new ArrayList<String>() {
        {
            add("Network Administrator");



        }
    };
    private ArrayList<String> webDevSubfield = new ArrayList<String>() {
        {
            add("Front-end Developer");
            add("Back-end Developer");


        }
    };
    private ArrayList<String> databaseSubField = new ArrayList<String>() {
        {

            add("Oracle Developer");

        }
    };

    //for checking which field , get list for its sub-field

    public ArrayList<String> checkSubField(String currentField) {
        if(currentField.equals("Mobile Development")){
        return getMobDevSubField();}
        else if(currentField.equals("Web Development")){
            return getWebDevSubField();}
        else if(currentField.equals("Artificial Intelligence")){
            return getAiSubField();}
        else if(currentField.equals("Network")){
            return getNetworkSubField();}
        else if(currentField.equals("Security")){
            return getSecuritySubField();}
        else {
            //        currentField.equals("Database")
            return getDatabaseSubField();
        }

    }



    //for checking which sub-field , get list for its roadmap

    public ArrayList<String> checkRoadmap(String currentSubField) {
        if(currentSubField.equals("Machine learning engineer")){
            machineLearningRoadMap obj = new machineLearningRoadMap();

            return obj.getMlRoad();}
        else if(currentSubField.equals("Data scientist")){
            dataScRoadMap obj=new dataScRoadMap();

            return obj.getDataScRoad();}
        else if(currentSubField.equals("Big data engineer")){
            bigDataRoadMap obj= new bigDataRoadMap();

            return obj.getBigDataRoad();}
        else if(currentSubField.equals("Oracle Developer")){
            databaseDevRoadMap obj = new databaseDevRoadMap();
            return obj.getDbRoad();}
        else if(currentSubField.equals("Network Administrator")){
            networkAdmisRoadMap obj =new networkAdmisRoadMap();
            return obj.getNetworkRoad();}
        else if(currentSubField.equals("Penetration testing")){
            penetrationTestRoadMap obj = new penetrationTestRoadMap();
            return obj.getPTestRoad();}
        else if(currentSubField.equals("Android development")){
            androidRoadMap obj = new androidRoadMap();
            return obj.getAndroidRoad();}
        else if(currentSubField.equals("Ios development")){
            iosRoadMap obj = new iosRoadMap();
            return obj.getIosRoad();}
        else if(currentSubField.equals("Front-end Developer")){
            frontendRoadMap obj = new frontendRoadMap();
            return obj.getFrontendRoad();}
        else {
            //        for backend Roadmap
            backendRoadMap obj =new backendRoadMap();
            return obj.getBackendRoad();
        }



    }

     public ArrayList<String> getAiSubField() {
        return aiSubfield;
    }

    public ArrayList<String> getSecuritySubField() {
        return securitySubField;
    }

    public ArrayList<String> getMobDevSubField() {
        return mobDevSubField;
    }

    public ArrayList<String> getNetworkSubField() {
        return networkSubField;
    }

    public ArrayList<String> getWebDevSubField() {
        return webDevSubfield;
    }

    public ArrayList<String> getDatabaseSubField() {
        return databaseSubField;
    }

    //
    public ArrayList<String> getFieldsTittles() {
        return fieldsTittles;
    }
}
