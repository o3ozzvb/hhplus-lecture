package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollment;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureEnrollmentJpaRespository extends JpaRepository<LectureEnrollment, Long> {
    List<LectureEnrollment> findByUserIdAndLectureId(long userId, long lectureId);

    @Lock(LockModeType.PESSIMISTIC_WRITE) // 비관적 쓰기 잠금
    @Query("SELECT le FROM LectureEnrollment le WHERE le.userId = :userId AND le.lectureId = :lectureId")
    List<LectureEnrollment> findByUserIdAndLectureIdWithLock(@Param("userId") long userId, @Param("lectureId") long lectureId);

    @Query(value = """
    SELECT l.*
    FROM lecture_enrollment le
    JOIN lecture l ON le.lecture_id = l.id
    WHERE le.user_id = :userId
    """, nativeQuery = true)
    List<Lecture> findEnrolledLecturesByUserId(long userId);

    // 테스트 시 사용
    int countByLectureId(Long lectureId);
}
