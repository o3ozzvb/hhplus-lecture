package com.example.hhplus_lecture.domain.lecture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LectureEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long lectureId;

    private LocalDateTime createdAt;

    public static LectureEnrollment of(Long userId, Long lectureId) {
        LectureEnrollment lectureEnrollment = new LectureEnrollment();

        lectureEnrollment.userId = userId;
        lectureEnrollment.lectureId = lectureId;
        lectureEnrollment.createdAt = LocalDateTime.now();

        return lectureEnrollment;
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

    /**
     * 존재하는 수강신청 내역인지 확인
     */
    public boolean isExist(Long userId, Long lectureId) {
        return this.userId.equals(userId) && this.lectureId.equals(lectureId);
    }
}

