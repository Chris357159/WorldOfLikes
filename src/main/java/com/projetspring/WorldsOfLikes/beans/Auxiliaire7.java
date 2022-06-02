package com.projetspring.WorldsOfLikes.beans;

public class Auxiliaire7 {
    private String myEmail;
    private String myPassword;
    private String myAddress;

    //

    public Auxiliaire7(String myEmail, String myPassword, String myAddress) {
        this.myEmail = myEmail;
        this.myPassword = myPassword;
        this.myAddress = myAddress;
    }
    ///

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword;
    }

    public String getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }
}
