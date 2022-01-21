package com.model;

import java.util.Date;

public class MedicalDeclaration {
    private int id;
    private String fullName;
    private Date dob;
    private String sex;
    private String nationality;
    private int identityCardNumber;
    private String travelInformation;
    private String vehicleNumber;
    private String seatNumber;
    private Date dateStart;
    private Date dateEnd;
    private String go14Day;
    private String city;
    private String district;
    private String commune;
    private String address;
    private int phoneNumber;
    private String email;
    private String[] symptom;

    public MedicalDeclaration(int id, String fullName, Date dob, String sex, String nationality, int identityCardNumber, String travelInformation, String vehicleNumber, String seatNumber, Date dateStart, Date dateEnd, String go14Day, String city, String district, String commune, String address, int phoneNumber, String email, String[] symptom) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.sex = sex;
        this.nationality = nationality;
        this.identityCardNumber = identityCardNumber;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.go14Day = go14Day;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptom = symptom;
    }

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String fullName, Date dob, String sex, String nationality, int identityCardNumber, String travelInformation, String vehicleNumber, String seatNumber, Date dateStart, Date dateEnd, String go14Day, String city, String district, String commune, String address, int phoneNumber, String email, String[] symptom) {
        this.fullName = fullName;
        this.dob = dob;
        this.sex = sex;
        this.nationality = nationality;
        this.identityCardNumber = identityCardNumber;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.go14Day = go14Day;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptom = symptom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(int identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getGo14Day() {
        return go14Day;
    }

    public void setGo14Day(String go14Day) {
        this.go14Day = go14Day;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }
}
