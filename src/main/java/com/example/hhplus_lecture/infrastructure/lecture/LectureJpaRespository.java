package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LectureJpaRespository extends JpaRepository<Lecture, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Lecture> findById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Lecture> findByLectureDateBetweenAndRemainSeatsGreaterThan(LocalDateTime startDate, LocalDateTime endDate, int remainSeats);
}
