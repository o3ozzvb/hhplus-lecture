package com.example.hhplus_lecture.domain.lecture;

import java.util.List;

public interface LectureEnrollmentRepository {
    /**
     * 강의 신청 내역 저장
     * @param lectureEnrollment 강의 신청 내역
     * @return 강의 신청 내역
     */
    LectureEnrollment save(LectureEnrollment lectureEnrollment);

    /**
     * 특정 userId의 모든 Registration 조회
     */
    List<LectureEnrollment> findByUserId(Long userId);

    /**
     * 같은 Lecture에 동일한 User가 중복 신청했는지 확인
     */
    boolean existsByUserIdAndLectureId(Long userId, Long lectureId);

    /**
     * 특정 Lecture의 현재 신청자 수
     */
    long countByLectureId(Long lectureId);
}
