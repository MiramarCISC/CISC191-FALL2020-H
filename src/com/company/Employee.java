package com.company;

public class Employee extends User{
    private String emplID;

    public Employee(String userName, String userEmail, String userPhone, String emplID) {
        super(userName, userEmail, userPhone);
        this.emplID = emplID;
    }

    @Override
    public void request() {
        System.out.println("Requesting verification for the receipt ...");
    }
}
