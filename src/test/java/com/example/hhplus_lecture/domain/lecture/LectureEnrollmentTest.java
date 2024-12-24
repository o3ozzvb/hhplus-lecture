package com.example.hhplus_lecture.domain.lecture;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LectureEnrollmentTest {

    @Test
    void 사용자가_이미_신청한_특강이면_true_리턴(){
        // given
        long userId = 1L;
        long lectureId = 1L;

        LectureEnrollment lectureEnrollment = LectureEnrollment.of(userId, lectureId);
        // when

        // then
        assertThat(lectureEnrollment.isExist(userId, lectureId)).isTrue();
    }

}