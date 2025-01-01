package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureEnrollmentJpaRespository extends JpaRepository<LectureEnrollment, Long> {
    List<LectureEnrollment> findByUserIdAndLectureId(long userId, long lectureId);

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
