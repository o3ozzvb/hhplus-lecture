package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LectureJpaRespository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByLectureDateBetweenAndRemainSeatsGreaterThan(LocalDateTime startDate, LocalDateTime endDate, int remainSeats);
}
