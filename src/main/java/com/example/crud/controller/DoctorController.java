package com.example.crud.controller;

import com.example.crud.entity.Doctor;
import com.example.crud.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/api/docteur")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("/api/docteur")
    public String getAllDoctors() { return doctorService.fetchAllDoctors()[0]; }

    @GetMapping("/api/docteur/{id}")
    public Doctor getDoctorById(@PathVariable("id") Long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/api/docteur/{id}")
    public Doctor updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctorById(id, doctor);
    }

    @DeleteMapping("/api/docteur/{id}")
    public String deleteDoctor(@PathVariable("id") Long id) {
        return doctorService.deleteDepartmentById(id);
    }
}
