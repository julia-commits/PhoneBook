package com.example.phonebook.DB;

import java.sql.Blob;
import java.sql.Date;

public class Contact {
    private String f_name, l_name, email, address, phone, gender;
    private Blob profile_pic;
    private Date dob;
    private int id;

    public Contact () {
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.profile_pic = profile_pic;
        this.dob = dob;
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }
    public void setF_name (String f_name) {
        this.f_name = f_name;
    }

    public String getL_name () {
        return l_name;
    }
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail () {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress () {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone () {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender () {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Blob getProfile_pic() {
        return profile_pic;
    }
    public void setProfile_pic(Blob profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getDob() {
        return String.valueOf(dob);
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
