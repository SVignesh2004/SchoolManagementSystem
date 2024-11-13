package com.as.AStask.Implement;

import com.as.AStask.School;
import com.as.AStask.service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class SchoolServiceImpl implements service {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("School not found"));
    }

    @Override
    public School updateSchool(Long id, School school) {
        School existingSchool = getSchoolById(id);
        existingSchool.setStudentId(school.getStudentId());
        existingSchool.setStudentName(school.getStudentName());
        existingSchool.setMarks(school.getMarks());
        existingSchool.setStudentAddress(school.getStudentAddress());
        existingSchool.setTeacherId(school.getTeacherId());
        existingSchool.setTeacherName(school.getTeacherName());
        return schoolRepository.save(existingSchool);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public List<School> filterByNameOrAddress(String keyword) {
        return schoolRepository.filterByStudentAndTeacherFields(keyword);
    }
}
