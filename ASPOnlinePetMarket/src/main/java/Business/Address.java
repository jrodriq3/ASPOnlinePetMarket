/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

/**
 *
 * @author jasonrodriguez
 */
public class Address {
    // Private fields to store the address components
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;

    public Address(){
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zipCode = 0;
    }
    // Constructor to initialize the address fields
    public Address(String streetAddress, String city, String state, int zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getter and setter methods for streetAddress
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    // Getter and setter methods for city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter and setter methods for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Getter and setter methods for zipCode
    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    // Overriding the toString() method for easy display of address information
    @Override
    public String toString() {
        return streetAddress + ", " + city + ", " + state + " " + zipCode;
    }
    public static void main(String[] args) {
        Address adr = new Address("200 willow lane", "Woodstock", "Ga", 30188);
    }
}
