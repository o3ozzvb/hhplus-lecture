package com.example.hhplus_lecture.interfaces.api.lecture;

import com.example.hhplus_lecture.domain.lecture.Lecture;
import com.example.hhplus_lecture.domain.lecture.LectureServiceImpl;
import com.example.hhplus_lecture.interfaces.dto.common.ApiResponse;
import com.example.hhplus_lecture.interfaces.dto.lecture.LectureEnrollRequest;
import com.example.hhplus_lecture.interfaces.dto.lecture.LectureRequest;
import com.example.hhplus_lecture.interfaces.dto.lecture.LectureResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LectureController {

    private final LectureServiceImpl lectureService;

    /**
     * (핵심)특강 신청 API
     * - 특정 userId 로 선착순으로 제공되는 특강을 신청하는 API 를 작성합니다.
     * - 동일한 신청자는 동일한 강의에 대해서 한 번의 수강 신청만 성공할 수 있습니다.
     * - 특강은 선착순 30명만 신청 가능합니다.
     * - 이미 신청자가 30명이 초과 되면 이후 신청자는 요청을 실패합니다.
     */
    @PostMapping("/lectures/enroll")
    public ResponseEntity<ApiResponse<Void>> enrollInLecture(@RequestBody LectureEnrollRequest request) {
        try {
            lectureService.enrollIn(request.getUserId(), request.getLectureId());
            return ResponseEntity.ok(ApiResponse.success(null));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(ApiResponse.failure(e.getMessage())
            );
        }
    }

    /**
     *  특강 신청 가능 목록 API**
     *  - 날짜별로 현재 신청 가능한 특강 목록을 조회하는 API 를 작성합니다.
     *  - 특강의 정원은 30명으로 고정이며, 사용자는 각 특강에 신청하기 전 목록을 조회해 볼 수 있어야 합니다.
     */
    @GetMapping("/lectures")
    public ResponseEntity<ApiResponse<List<LectureResponse>>> getAvailableLectures(@Valid LectureRequest request) {
        log.debug("getAvailableLectures request: {}", request);
        List<Lecture> lectures = lectureService.findAvailableLectures(request.getStartDate(), request.getEndDate());

        List<LectureResponse> response = lectures.stream()
                .map(LectureResponse::from)
                .collect(Collectors.toList());

        log.debug("getAvailableLectures response: {}", response);

        return ResponseEntity.ok(
                ApiResponse.success(response)
        );
    }

    /**
     * 특정 사용자 신청 목록 조회
     */
    @GetMapping("/lectures/{userId}")
    public ResponseEntity<ApiResponse<List<LectureResponse>>> getEnrollmentsByUser(@PathVariable Long userId) {
        List<Lecture> enrolledLectures = lectureService.findEnrolledLecturesByUserId(userId);

        List<LectureResponse> response = enrolledLectures.stream()
                .map(LectureResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                ApiResponse.success(response)
        );
    }

}
