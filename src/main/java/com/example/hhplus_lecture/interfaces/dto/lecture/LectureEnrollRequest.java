package com.example.hhplus_lecture.interfaces.dto.lecture;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LectureEnrollRequest {
    Long userId;
    Long lectureId;
}
