package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.LectureEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureEnrollmentJpaRespository extends JpaRepository<LectureEnrollment, Long> {
    List<LectureEnrollment> findByUserIdAndLectureId(long userId, long lectureId);
    List<LectureEnrollment> findByUserId(long userId);
}
