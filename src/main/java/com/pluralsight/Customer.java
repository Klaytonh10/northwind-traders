package com.pluralsight;

public class Customer {

    private String id;
    private String contactName;
    private String company;
    private String city;
    private String country;
    private String phoneNumber;

    public Customer(String id, String contactName, String company, String city, String country, String phoneNumber) {
        this.id = id;
        this.contactName = contactName;
        this.company = company;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getContactName() {
        return contactName;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
