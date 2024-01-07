package com.example.crud.service;

import com.example.crud.entity.Doctor;
import com.example.crud.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public String[] fetchAllDoctors() {
        final String[] res = {""};

        List<Doctor> allDoctors = doctorRepository.findAll();
        allDoctors.forEach(doctor -> {

            res[0] +=  String.format("""
                <tr>
                    <td> %s </td>
                    <td> %s </td>
                    <td> %s </td>
                    <td> %s </td>
                    <td><center>
                        <button onclick="showWindow('edit', %s)">
                            <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" width="24px" height="24px">    <path d="M 18 2 L 15.585938 4.4140625 L 19.585938 8.4140625 L 22 6 L 18 2 z M 14.076172 5.9238281 L 3 17 L 3 21 L 7 21 L 18.076172 9.9238281 L 14.076172 5.9238281 z"/></svg>
                        </button>
                        
                        <button hx-confirm="Are you sure you wish to delete this doctor ?" hx-delete="/api/docteur/%s">
                            <svg class="delete" xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" width="24px" height="24px"><path d="M 10 2 L 9 3 L 3 3 L 3 5 L 21 5 L 21 3 L 15 3 L 14 2 L 10 2 z M 4.3652344 7 L 6.0683594 22 L 17.931641 22 L 19.634766 7 L 4.3652344 7 z"/></svg>
                        </button>
                    </center></td>
                </tr>""", doctor.getDoctorId(), doctor.getDoctorCin(), doctor.getDoctorName(), doctor.getDoctorSpecialty(), doctor.getDoctorId(), doctor.getDoctorId());
        });
        return res;
    }

    @Override
    public Doctor getDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return doctor.get();
        }
        return null;
    }

    @Override
    public Doctor updateDoctorById(Long id, Doctor doctor) {
        Optional<Doctor> doctor1 = doctorRepository.findById(id);

        if (doctor1.isPresent()) {
            Doctor originalDoctor = doctor1.get();

            if (Objects.nonNull(doctor.getDoctorName()) && !"".equalsIgnoreCase(doctor.getDoctorName())) {
                originalDoctor.setDoctorName(doctor.getDoctorName());
            }
            if (Objects.nonNull(doctor.getDoctorCin()) && doctor.getDoctorCin() != 0) {
                originalDoctor.setDoctorCin(doctor.getDoctorCin());
            }
            return doctorRepository.save(originalDoctor);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        if (doctorRepository.findById(id).isPresent()) {
            doctorRepository.deleteById(id);
            return "<svg class=\"delete\" xmlns=\"http://www.w3.org/2000/svg\"  viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\"><path d=\"M 10 2 L 9 3 L 3 3 L 3 5 L 21 5 L 21 3 L 15 3 L 14 2 L 10 2 z M 4.3652344 7 L 6.0683594 22 L 17.931641 22 L 19.634766 7 L 4.3652344 7 z\"/></svg>\n";
        }
        return "No such doctor in the database";
    }
}
