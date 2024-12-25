package com.example.hhplus_lecture.domain.lecture;

import java.util.List;

public interface LectureEnrollmentRepository {

    LectureEnrollment save(LectureEnrollment lectureEnrollment);

    List<LectureEnrollment> findBy(long userId, long lectureId);

    List<Lecture> findEnrolledLecturesByUserId(Long userId);

    List<LectureEnrollment> findAll();
    void deleteAll();
}
