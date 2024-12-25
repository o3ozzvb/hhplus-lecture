package com.example.hhplus_lecture.domain.lecture;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class LectureTest {

    @Test
    void 여석이_없는_특강이면_true_리턴() {
        // given
        Lecture lecture = 특강_생성(1L, "특강 1", "김강사", "202412251300", 0);

        // when

        // then
        assertThat(lecture.isFull()).isTrue();
    }

    private Lecture 특강_생성(long id, String name, String lecturer, String lectureDateTime, int remainSeats) {
        // String to LocalDatTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        return Lecture.of(name, lecturer, LocalDateTime.parse(lectureDateTime, formatter), 30, remainSeats);
    }

}