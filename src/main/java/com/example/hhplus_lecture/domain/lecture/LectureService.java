package com.example.hhplus_lecture.domain.lecture;

import java.util.List;

public interface LectureService {

    /** 특강 신청 */
    void enrollIn(long userId, long lectureId);

    /** 신청 가능한 특강 목록 조회 (날짜) */
    List<Lecture> findAvailableLectures(String startDate, String endDate);

    /** 특정 사용자가 신청한 강의 목록 조회 */
    List<LectureEnrollment> findLectureEnrollmentsByUserId(long userId);
}
