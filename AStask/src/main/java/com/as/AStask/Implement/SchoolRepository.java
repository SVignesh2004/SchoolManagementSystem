package com.as.AStask.Implement;

import com.as.AStask.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {


    @Query("SELECT s FROM School s " +
            "WHERE LOWER(s.studentId) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.studentName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.studentAddress) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.teacherId) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.teacherName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<School> filterByStudentAndTeacherFields(@Param("keyword") String keyword);
}
