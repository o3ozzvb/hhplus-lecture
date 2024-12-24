package com.example.hhplus_lecture.domain.lecture;

import com.example.hhplus_lecture.support.exception.BusinessException;
import com.example.hhplus_lecture.support.exception.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.hhplus_lecture.fixture.LectureFixture.createLecture;
import static com.example.hhplus_lecture.fixture.LectureFixture.특강1;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class LectureServiceTest {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureEnrollmentRepository lectureEnrollmentRepository;

    Lecture lecture;
    long userId = 1L;
    long lectureId;

    @BeforeEach
    void beforeEach() {
        lecture = lectureRepository.save(특강1());
        lectureId = lecture.getId();
    }

    @Test
    void 여석없는_특강신청시_예외발생(){
        // given
        Lecture newLecture = lectureRepository.save(createLecture("특강2", "김선생", "202412251600", 0));

        lectureId = newLecture.getId();

        // when

        // then
        assertThatThrownBy(() -> lectureService.enrollIn(userId, lectureId))
                .isInstanceOf(BusinessException.class)
                .hasMessage(ErrorCode.LECTURE_FULL.getMessage());
    }

    @Test
    void 동일사용자가_동일특강신청시_예외발생(){
        // given
        lectureEnrollmentRepository.save(LectureEnrollment.of(userId, lectureId));

        // when

        // then
        assertThatThrownBy(() -> lectureService.enrollIn(userId, lectureId))
                .isInstanceOf(BusinessException.class)
                .hasMessage(ErrorCode.DUPLICATE_REGISTRATION.getMessage());
    }

    @Test
    void 특강신청_성공(){
        // given

        // when
        lectureService.enrollIn(userId, lectureId);

        // then
        List<LectureEnrollment> lectureEnrollments = lectureEnrollmentRepository.findBy(userId, lectureId);
        assertThat(lectureEnrollments).hasSize(1)
                .extracting("userId", "lectureId")
                .containsExactly(
                        tuple(userId, lectureId)
                );
    }

    @Test
    void 특강신청_성공시_여석이_차감된다(){
        // given

        // when
        lectureService.enrollIn(userId, lectureId);

        // then
        Lecture findLecture = lectureRepository.findById(lectureId);
        assertThat(findLecture.getRemainSeats()).isEqualTo(lecture.getRemainSeats() - 1);
    }
}