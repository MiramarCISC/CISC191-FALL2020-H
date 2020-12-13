/*
 * Contributors: Tu Hoang
 **/
package edu.sdccd.cisc191.h.db_model;

/*
 * This is the model class for CUSTOMER table.
 **/


public class Customer {
    private String cId;
    private String cName;
    private int cAge;
    private String cEmail;
    private String cPhone;
    private String cAddress;
    //Constructor
    public Customer(String cId, String cName, int cAge, String cEmail, String cPhone, String cAddress) {
        this.cId = cId;
        this.cName = cName;
        this.cAge = cAge;
        this.cEmail = cEmail;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
    }
    //Setters and getters
    public String getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public int getcAge() {
        return cAge;
    }

    public String getcPhone() {
        return cPhone;
    }

    public String getcAddress() {
        return cAddress;
    }

    public String getcEmail() {
        return cEmail;
    }
}
