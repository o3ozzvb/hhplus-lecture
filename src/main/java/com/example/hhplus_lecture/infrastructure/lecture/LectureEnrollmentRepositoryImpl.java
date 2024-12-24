package com.example.hhplus_lecture.infrastructure.lecture;

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
    public List<LectureEnrollment> findBy(long userId, long lectureId) {
        return lectureEnrollmentJpaRespository.findByUserIdAndLectureId(userId, lectureId);
    }

    @Override
    public List<LectureEnrollment> findAllByUserId(Long userId) {
        return lectureEnrollmentJpaRespository.findAllByUserId(userId);
    }
}
