package com.example.hhplus_lecture.domain.lecture;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LectureEnrollments {

    private final List<LectureEnrollment> lectureEnrollments;

    public boolean isEnrollmentExists(long userId, long lectureId) {
        return lectureEnrollments.stream()
                .anyMatch(enrollment -> enrollment.isExist(userId, lectureId));
    }

}
