package com.example.assigment_of_quantum;

public class infoOfUser {
    String name,email,contactNo,password;
//    String image,date,info,data;

    public infoOfUser( String name,String email, String contactNo,String password) {
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
    }

//    public  infoOfUser( String name,String image, String date, String info, String data){
//        this.name= name;
//        this.image = image;
//        this.date = date;
//        this.info = info;
//        this.data = data;
//    }
    public  infoOfUser(){}
    public infoOfUser(String email,String password){
        this.password = password;
        this.email = email;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }





//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }
}
