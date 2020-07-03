package com.omaressam.rode.Data;

public class UserCourses {
    private int Bid=0;
    private int rate=0;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    private String feedback="null";


    private Boolean accepted=false;

    public int getBid() {
        return Bid;
    }

    public void setBid(int bid) {
        this.Bid = bid;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}
