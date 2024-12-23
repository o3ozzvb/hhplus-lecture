package com.example.hhplus_lecture.infrastructure.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureRepositoryImpl implements Lecture.LectureRepository {

    @Override
    public List<Lecture> findAll() {
        return null;
    }
}
