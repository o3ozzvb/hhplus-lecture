package com.example.hhplus_lecture.interfaces.dto.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class LectureResponse {

    private String name;

    private String lecturer;

    private LocalDateTime lectureDate;

    private Integer capacity;

    private Integer remainSeats;

    private LocalDateTime createdAt;

    public static LectureResponse from(Lecture lecture) {
        return new LectureResponse(
                lecture.getName(),
                lecture.getLecturer(),
                lecture.getLectureDate(),
                lecture.getCapacity(),
                lecture.getRemainSeats(),
                lecture.getCreatedAt()
        );
    }
}
