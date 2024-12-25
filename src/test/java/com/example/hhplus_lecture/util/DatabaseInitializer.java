package com.example.hhplus_lecture.util;

import com.example.hhplus_lecture.domain.lecture.LectureEnrollmentRepository;
import com.example.hhplus_lecture.domain.lecture.LectureRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseInitializer {

    private final LectureRepository lectureRepository;
    private final LectureEnrollmentRepository lectureEnrollmentRepository;

    public DatabaseInitializer(LectureRepository lectureRepository, LectureEnrollmentRepository lectureEnrollmentRepository) {
        this.lectureRepository = lectureRepository;
        this.lectureEnrollmentRepository = lectureEnrollmentRepository;
    }

    @Transactional
    public void resetDatabase() {
        lectureEnrollmentRepository.deleteAll();
        lectureRepository.deleteAll();
    }
}
