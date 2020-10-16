package com.company;
import java.lang.String;

public class Customer extends User{ //Class represents a customer's properties

    private String ctCollegeID; //Customer's collegeID

    public Customer(String userName, String userEmail, String userPhone, String ctCollegeID) {
        super(userName, userEmail, userPhone);
        this.ctCollegeID = ctCollegeID;
    }

    //Default Constructor

     //Constructor with arguments


    @Override
    public void request() {
        System.out.println("Requesting checkout ...");
    }

    @Override
    public String toString() { //Return one line that is stored customer's info
        return "Customer " +
                super.getUserName() + " " +
                super.getUserEmail() + " " +
                super.getUserPhone() + " " +
                this.ctCollegeID;
    }
}
