package com.example.crud.service;

import com.example.crud.entity.Doctor;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    String[] fetchAllDoctors();

    Doctor getDoctorById(Long id);

    Doctor updateDoctorById(Long id, Doctor doctor);

    String deleteDepartmentById(Long id);
}
