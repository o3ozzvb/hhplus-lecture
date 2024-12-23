package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.LectureEnrollment;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollmentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureEnrollmentRepositoryImpl implements LectureEnrollmentRepository {

    @Override
    public LectureEnrollment save(LectureEnrollment lectureEnrollment) {
        return null;
    }

    @Override
    public List<LectureEnrollment> findByUserId(Long userId) {
        return null;
    }

    @Override
    public boolean existsByUserIdAndLectureId(Long userId, Long lectureId) {
        return false;
    }

    @Override
    public long countByLectureId(Long lectureId) {
        return 0;
    }
}
