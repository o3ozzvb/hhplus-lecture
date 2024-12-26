package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollment;
import com.example.hhplus_lecture.domain.lecture.LectureEnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class LectureEnrollmentRepositoryImpl implements LectureEnrollmentRepository {
    private final LectureEnrollmentJpaRespository lectureEnrollmentJpaRespository;

    @Override
    public LectureEnrollment save(LectureEnrollment lectureEnrollment) {
        return lectureEnrollmentJpaRespository.save(lectureEnrollment);
    }

    @Override
    public List<Lecture> findEnrolledLecturesByUserId(Long userId) {
        return lectureEnrollmentJpaRespository.findEnrolledLecturesByUserId(userId);
    }

    @Override
    public List<LectureEnrollment> findAll() {
        return lectureEnrollmentJpaRespository.findAll();
    }

    @Override
    public List<LectureEnrollment> findBy(long userId, long lectureId) {
        return lectureEnrollmentJpaRespository.findByUserIdAndLectureId(userId, lectureId);
    }

    @Override
    public void deleteAll() {
        lectureEnrollmentJpaRespository.deleteAll();
    }
}
