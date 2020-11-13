package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
    String email;
    String userName;
    String password;
    String state;
    String fullname;
    String street;
    String city;
    String gender;
    UserStatus status;
    int zipCode;

    public User(String email, String userName, String password, String state, String fullname, String street, String city, String gender, UserStatus status, int zipCode) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.state = state;
        this.fullname = fullname;
        this.street = street;
        this.city = city;
        this.gender = gender;
        this.status = status;
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public UserStatus getStatus() {
        return status;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public static String hashPassword(String password) {
        String hashedPassword = null;
        try {
            byte [] hash = MessageDigest
                    .getInstance("SHA-256")
                    .digest(password.getBytes(StandardCharsets.UTF_8));
            hashedPassword = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }
}
