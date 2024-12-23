package com.example.hhplus_lecture.interfaces.api.lecture;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

    /** todo
        (핵심)특강 신청 API
        - 특정 userId 로 선착순으로 제공되는 특강을 신청하는 API 를 작성합니다.
        - 동일한 신청자는 동일한 강의에 대해서 한 번의 수강 신청만 성공할 수 있습니다.
        - 특강은 선착순 30명만 신청 가능합니다.
        - 이미 신청자가 30명이 초과 되면 이후 신청자는 요청을 실패합니다.
     */

    /** todo
     *  특강 신청 가능 목록 API**
     *  - 날짜별로 현재 신청 가능한 특강 목록을 조회하는 API 를 작성합니다.
     *  - 특강의 정원은 30명으로 고정이며, 사용자는 각 특강에 신청하기 전 목록을 조회해 볼 수 있어야 합니다.
     */

}
