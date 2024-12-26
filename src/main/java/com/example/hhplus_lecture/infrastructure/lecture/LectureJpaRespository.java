package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface LectureJpaRespository extends JpaRepository<Lecture, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT l FROM Lecture l WHERE l.id = :lectureId")
    Lecture findLectureWithLock(@Param("lectureId") Long lectureId);

    List<Lecture> findByLectureDateBetweenAndRemainSeatsGreaterThan(LocalDateTime startDate, LocalDateTime endDate, int remainSeats);
}
