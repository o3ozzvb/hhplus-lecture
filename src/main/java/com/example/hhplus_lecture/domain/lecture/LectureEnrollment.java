package com.example.hhplus_lecture.domain.lecture;

import java.time.LocalDateTime;

public class LectureEnrollment {

    private final Long id;
    private final Long userId;
    private final Long lectureId;
    private final LocalDateTime createdAt;

    public LectureEnrollment(Long id, Long userId, Long lectureId, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.lectureId = lectureId;
        this.createdAt = createdAt;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

