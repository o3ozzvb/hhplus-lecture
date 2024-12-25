package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollment;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollmentRepository;
import com.example.hhplus_lecture.domain.lecture.LectureRepository;
import com.example.hhplus_lecture.util.DatabaseInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.example.hhplus_lecture.fixture.LectureFixture.createLecture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

@SpringBootTest
@ActiveProfiles("test")
class LectureEnrollmentRepositoryImplTest {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureEnrollmentRepository lectureEnrollmentRepository;

    @Autowired
    private DatabaseInitializer databaseInitializer;

    @BeforeEach
    public void setUp() {
        databaseInitializer.resetDatabase();
    }

    @Test
    void save() {
        // given
        long userId = 1L;
        long lectureId = 1L;

        // when
        lectureEnrollmentRepository.save(LectureEnrollment.of(userId, lectureId));

        // then
        List<LectureEnrollment> lectureEnrollments = lectureEnrollmentRepository.findAll();

        assertThat(lectureEnrollments).isNotEmpty();
        assertThat(lectureEnrollments.size()).isEqualTo(1);
        assertThat(lectureEnrollments).extracting("userId", "lectureId")
                .containsExactly(tuple(userId, lectureId));
    }

    @Test
    void findEnrolledLecturesByUserId() {
        // given
        long userId = 1L;

        Lecture lecture1 = lectureRepository.save(createLecture("특강1", "강사1", "202412241300", 30));
        Lecture lecture2 = lectureRepository.save(createLecture("특강2", "강사2", "202412271300", 30));

        lectureEnrollmentRepository.save(LectureEnrollment.of(userId, lecture1.getId()));
        lectureEnrollmentRepository.save(LectureEnrollment.of(userId, lecture2.getId()));

        // when
        List<Lecture> enrolledLectures = lectureEnrollmentRepository.findEnrolledLecturesByUserId(userId);

        // then
        assertThat(enrolledLectures).hasSize(2)
                .extracting("id","name", "lecturer")
                .containsExactly(
                        tuple(lecture1.getId(), "특강1", "강사1"),
                        tuple(lecture2.getId(), "특강2", "강사2")
                );
    }
}