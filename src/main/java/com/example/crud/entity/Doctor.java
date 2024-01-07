package com.example.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;

    private String doctorName;

    private String doctorSpecialty;

    private int doctorCin;

    public Doctor() {
    }

    public Doctor(Long doctorId, String doctorName, String doctorSpecialty, int doctorCin) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSpecialty = doctorSpecialty;
        this.doctorCin = doctorCin;
    }

    public Doctor( String doctorName, int doctorCin) {
        this.doctorName = doctorName;
        this.doctorCin = doctorCin;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpecialty() {
        return doctorSpecialty;
    }

    public void setDoctorSpecialty(String doctorSpecialty) {
        this.doctorSpecialty = doctorSpecialty;
    }

    public int getDoctorCin() {
        return doctorCin;
    }

    public void setDoctorCin(int doctorCin) {
        this.doctorCin = doctorCin;
    }
}
