package com.example.hhplus_lecture.domain.lecture;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lecturer;

    private LocalDateTime lectureDate;

    private Integer capacity;

    private Integer remainSeats;

    private LocalDateTime createdAt;

    // 생성자: id 필드를 포함하지 않음
    public static Lecture of(String name, String lecturer, LocalDateTime lectureDate, Integer capacity, Integer remainSeats) {
        Lecture lecture = new Lecture();

        lecture.name = name;
        lecture.lecturer = lecturer;
        lecture.lectureDate = lectureDate;
        lecture.capacity = capacity;
        lecture.remainSeats = remainSeats;
        lecture.createdAt = LocalDateTime.now();

        return lecture;
    }

    public boolean isFull() {
        return remainSeats <= 0;
    }

    public void decreseRemainSeats() {
        this.remainSeats = this.remainSeats - 1;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public LocalDateTime getLectureDate() {
        return lectureDate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getRemainSeats() { return remainSeats; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}