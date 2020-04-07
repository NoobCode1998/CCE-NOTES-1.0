package com.jcupzz.ccenotes;

public class role {

    String uid,email,uploadRight,pass;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        uid = uid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        uid = pass;
    }

    public String getUploadRight() {
        return uploadRight;
    }

    public void setUploadRight(String uid) {
        uploadRight = uploadRight;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }
    public role(String uid, String email,String uploadRight,String pass){
        this.email=email;
        this.uid=uid;
        this.uploadRight=uploadRight;
        this.pass=pass;

    }

}