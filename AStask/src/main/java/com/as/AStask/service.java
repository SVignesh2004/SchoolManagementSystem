package com.as.AStask;

import java.util.List;

public interface service {
    School addSchool(School school);
    List<School> getAllSchools();
    School getSchoolById(Long id);
    School updateSchool(Long id, School school);
    void deleteSchool(Long id);

    List<School> filterByNameOrAddress(String keyword);
}
