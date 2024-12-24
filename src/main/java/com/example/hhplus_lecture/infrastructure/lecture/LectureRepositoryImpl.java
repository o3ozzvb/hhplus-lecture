package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureRepository;
import com.example.hhplus_lecture.support.exception.BusinessException;
import com.example.hhplus_lecture.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class LectureRepositoryImpl implements LectureRepository {
    private final LectureJpaRespository lectureJpaRespository;

    @Override
    public Lecture save(Lecture lecture) {
        return lectureJpaRespository.save(lecture);
    }

    @Override
    public Lecture findById(Long id) {
        return lectureJpaRespository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.LECTURE_NOT_EXIST));
    }

    @Override
    public List<Lecture> findAll() {
        return lectureJpaRespository.findAll();
    }
}
