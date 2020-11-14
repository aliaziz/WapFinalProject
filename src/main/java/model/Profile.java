package model;

public class Profile {
    String userName;
    String gender;
    String email;
    String fullName;
    String state;
    String city;
    String street;
    int zipCode;

    public Profile(String userName, String gender, String email, String fullName, String state, String city, String street, int zipCode) {
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.fullName = fullName;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getZipCode() {
        return zipCode;
    }
}
