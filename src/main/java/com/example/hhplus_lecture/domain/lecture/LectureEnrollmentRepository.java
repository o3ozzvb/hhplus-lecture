package com.example.hhplus_lecture.domain.lecture;

import java.util.List;

public interface LectureEnrollmentRepository {

    LectureEnrollment save(LectureEnrollment lectureEnrollment);

    List<LectureEnrollment> findBy(long userId, long lectureId);

    List<LectureEnrollment> findByUserIdAndLectureIdWithLock(long userId, long lectureId);

    List<Lecture> findEnrolledLecturesByUserId(Long userId);

    List<LectureEnrollment> findAll();
    void deleteAll();
    // 테스트 시 사용
    int countByLectureId(Long lectureId);
}
