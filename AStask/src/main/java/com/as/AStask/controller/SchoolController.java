package com.as.AStask.controller;

import com.as.AStask.School;
import com.as.AStask.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    private service schoolService;

    @PostMapping
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.addSchool(school));
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolService.getSchoolById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School school) {
        return ResponseEntity.ok(schoolService.updateSchool(id, school));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/filter")
    public ResponseEntity<List<School>> filterByStudentAndTeacherFields(@RequestParam String keyword) {
        List<School> filteredSchools = schoolService.filterByNameOrAddress(keyword);
        return ResponseEntity.ok(filteredSchools);
    }
}
