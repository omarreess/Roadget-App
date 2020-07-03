package com.omaressam.rode.Data;

public class Course {
    public Course (){};

    public Course(String courseName , String placeName , String instructor, int price, String date, String descreption, String location  , String subField , String field) {
        this.courseName = courseName;
        this.placeName = placeName;
        this.instructor = instructor;
        this.price = price;
        this.date = date;
        this.descreption = descreption;
        this.location = location;
        this.subField =subField;
        this.field = field;





    }





    public String getSubField() {
        return subField;
    }

    public void setSubField(String subField) {
        this.subField = subField;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        //admin id
        this.AID = AID;
    }

    public void setRoadmapRate(int roadmapRate) {
        this.roadmapRate = roadmapRate;
    }

    private String subField = "null" ;
    private String field = "null" ;
    private String BID = "null" ;
    //admin id
    private String AID = "null" ;



    private String instructor = "null" ;
    private int price ;
    private String date = "null" ;
    private String descreption = "null";
    private int id   ;




    private int rate;
    private String courseName= "null";
    private String placeName= "null";

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getRoadmapRate() {
        return roadmapRate;
    }

    private int roadmapRate;

    private String location= "null";

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
