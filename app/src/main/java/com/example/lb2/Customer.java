package com.example.lb2;




public class Customer {


    public long getmCustomerId() {
        return mCustomerId;
    }

    public void setmCustomerId(long mCustomerId) {
        this.mCustomerId = mCustomerId;
    }

    private long mCustomerId ;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    private String mName;

    private String mPhone;
    private String mGender;

    public String getMaddress() {
        return maddress;
    }

    public void setMaddress(String maddress) {
        this.maddress = maddress;
    }

    private String maddress;
    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public Customer() { }
    public Customer(long mCustomerId, String mName, String mPhone, String mGender , String maddress) {
        this.mCustomerId = mCustomerId;
        this.mName = mName;
        this.mPhone = mPhone;
        this.mGender = mGender;
        this.maddress = maddress;
    }

}
