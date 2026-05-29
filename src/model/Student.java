/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Student implements Serializable{
    private String id;
    private String name;
    private String phone;
    private String email;
    private String mountainCode;
    private double tutionFee;

    public Student() {
    }

    public Student(String id, String name, String phone, String email, String mountainCode, double tutionFee) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tutionFee = tutionFee;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mountainCode
     */
    public String getMountainCode() {
        return mountainCode;
    }

    /**
     * @param mountainCode the mountainCode to set
     */
    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    /**
     * @return the tutionFee
     */
    public double getTutionFee() {
        return tutionFee;
    }

    /**
     * @param tutionFee the tutionFee to set
     */
    public void setTutionFee(double tutionFee) {
        this.tutionFee = tutionFee;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-10s | %-25s | %-15s | %-,15.0f |\n", id, name, phone, email, mountainCode, tutionFee);
    }

    
    
    
}
