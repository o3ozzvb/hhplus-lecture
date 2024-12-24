package com.example.hhplus_lecture.domain.lecture;

import java.util.List;

public interface LectureRepository {
    Lecture save(Lecture lecture);
    Lecture findById(Long id);
    List<Lecture> findAll();
}
