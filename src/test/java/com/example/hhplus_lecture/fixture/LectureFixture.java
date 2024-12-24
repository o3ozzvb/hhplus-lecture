package com.example.hhplus_lecture.fixture;

import com.example.hhplus_lecture.domain.lecture.Lecture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LectureFixture {

    public static Lecture 특강1() {
        return createLecture("특강1", "김강사", "202412251300", 30);
    }

    public static Lecture createLecture(String name, String lecturer, String lectureDateTime, int remainSeats) {
        // String to LocalDatTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        return Lecture.of(name, lecturer, LocalDateTime.parse(lectureDateTime, formatter), 30, remainSeats);
    }
}
