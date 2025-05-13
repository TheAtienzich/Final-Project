import java.util.*;

public class Cliente extends Usuario{
    private String name;
    private String surname;
    private String address;
    private int phoneNumber;
    private String DNI;
    private String postalCode;
    private String province;
    private String locality;
    private CreditCard creditCardClient;
    private List<Order> ordersClient;

    public Cliente(String name, String surname, String email, String passWord) {
        super(email, passWord, name);
        this.surname = surname;
        ordersClient = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard getCreditCardClient() {
        return creditCardClient;
    }

    public void setCreditCardClient(CreditCard creditCardClient) {
        this.creditCardClient = creditCardClient;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
