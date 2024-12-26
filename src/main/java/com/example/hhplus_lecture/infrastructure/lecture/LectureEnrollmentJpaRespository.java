package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollment;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureEnrollmentJpaRespository extends JpaRepository<LectureEnrollment, Long> {

    // 강의 신청 시 비관적 락 사용
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    LectureEnrollment save(LectureEnrollment lectureEnrollment);

    List<LectureEnrollment> findByUserIdAndLectureId(long userId, long lectureId);

    @Query(value = """
    SELECT l.*
    FROM lecture_enrollment le
    JOIN lecture l ON le.lecture_id = l.id
    WHERE le.user_id = :userId
    """, nativeQuery = true)
    List<Lecture> findEnrolledLecturesByUserId(long userId);

    int countByLectureId(Long lectureId);
}
