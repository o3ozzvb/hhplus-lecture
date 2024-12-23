package com.example.hhplus_lecture.domain.lecture;

import java.time.LocalDateTime;
import java.util.List;

public class Lecture {

    private final Long id;
    private final String name;
    private final String lecturer;
    private final LocalDateTime lectureDate;
    private final Integer capacity;
    private final LocalDateTime createdAt;

    public Lecture(Long id, String name, String lecturer, LocalDateTime lectureDate,
                   Integer capacity, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.lectureDate = lectureDate;
        this.capacity = capacity;
        this.createdAt = createdAt;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public LocalDateTime getLectureDate() {
        return lectureDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static interface LectureRepository {

        /**
         * 특강 전체 목록 조회
         * @return 특강 목록
         */
        List<Lecture> findAll();
    }
}