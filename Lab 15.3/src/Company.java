import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
    private long serialVersionUID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String postcode;
    private String country;
    private Date createdDate;

    public Company(String name, String email, String phone, String address, String postcode, String country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.country = country;
    }

    public Company() {

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "Company: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Address: " + address + "\n" +
                "Postcode: " + postcode + "\n" +
                "Country: " + country + "\n";
    }
}
