package com.example.hhplus_lecture.domain.lecture;

import java.time.LocalDateTime;
import java.util.List;

public interface LectureRepository {
    Lecture save(Lecture lecture);
    Lecture findById(Long id);
    Lecture findLectureWithLock(Long id);

    List<Lecture> findAvailableLectures(LocalDateTime startDate, LocalDateTime endDate, int remainSeats);

    List<Lecture> findAll();
    void deleteAll();
}
