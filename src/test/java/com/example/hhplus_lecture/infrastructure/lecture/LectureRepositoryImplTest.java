package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureRepository;
import com.example.hhplus_lecture.util.DatabaseInitializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.hhplus_lecture.fixture.LectureFixture.createLecture;
import static com.example.hhplus_lecture.fixture.LectureFixture.특강1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@ActiveProfiles("test")
class LectureRepositoryImplTest {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    private DatabaseInitializer databaseInitializer;

    @BeforeEach
    public void setUp() {
        databaseInitializer.resetDatabase();
    }

    @Test
    void save() {
        // given

        // when
        lectureRepository.save(특강1());

        // then
        List<Lecture> lectures = lectureRepository.findAll();

        assertThat(lectures).isNotEmpty();
        assertThat(lectures.size()).isEqualTo(1);
        assertThat(lectures.get(0).getName()).isEqualTo(특강1().getName());
    }

    @Test
    void findAvailableLectures() {
        // given
        lectureRepository.save(createLecture("특강1", "강사1", "202412241300", 30));
        lectureRepository.save(createLecture("특강2", "강사2", "202412271300", 30));
        lectureRepository.save(createLecture("특강3", "강사3", "202412311300", 30));
        lectureRepository.save(createLecture("특강4", "강사4", "202412311300", 0));

        LocalDateTime date20241225 = LocalDateTime.of(2024, 12, 25, 00, 00);
        LocalDateTime date20241231 = LocalDateTime.of(2024,12,31,23,59);

        // when
        List<Lecture> availableLectures = lectureRepository.findAvailableLectures(date20241225, date20241231, 0);

        // then
        assertThat(availableLectures).hasSize(2);
        assertThat(availableLectures).extracting("name", "lecturer")
                .containsExactly(
                        tuple("특강2", "강사2"),
                        tuple("특강3", "강사3")
                );
    }
}