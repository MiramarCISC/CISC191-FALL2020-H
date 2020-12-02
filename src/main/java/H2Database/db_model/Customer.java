package H2Database.db_model;

public class Customer {
    private String cId;
    private String cName;
    private int cAge;
    private String cPhone;
    private String cAddress;
    private String cEmail;

    public Customer(String cId, String cName, int cAge, String cPhone, String cAddress, String cEmail) {
        this.cId = cId;
        this.cName = cName;
        this.cAge = cAge;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cEmail = cEmail;
    }

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
