package com.example.hhplus_lecture.domain.lecture;

import com.example.hhplus_lecture.support.exception.BusinessException;
import com.example.hhplus_lecture.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final LectureEnrollmentRepository lectureEnrollmentRepository;

    /** 특강 신청하기 */
    @Override
    @Transactional
    public LectureEnrollment enrollIn(long userId, long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId);

        // 특강 여석이 있는지
        if (lecture.isFull()) {
            throw new BusinessException(ErrorCode.LECTURE_FULL);
        }
        // 동일 사용자가 동일 특강에 신청한 내역이 있는지
        List<LectureEnrollment> lectureEnrollments = lectureEnrollmentRepository.findBy(userId, lectureId);
        if (lectureEnrollments.size() > 0) {
            throw new BusinessException(ErrorCode.DUPLICATE_REGISTRATION);
        }

        // 여석 차감
        lecture.decreseRemainSeats();
        lectureRepository.save(lecture);

        return lectureEnrollmentRepository.save(LectureEnrollment.of(userId, lectureId));
    }

    @Override
    @Transactional
    public List<Lecture> findAvailableLectures(String startDate, String endDate) {
        String startTime = "000000"; // 00시 00분 00초
        String endTime = "235959"; // 23시 59분 59초
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime lStartDate = LocalDateTime.parse(startDate + startTime, formatter);
        LocalDateTime lEndDate = LocalDateTime.parse(endDate + endTime, formatter);

        return lectureRepository.findAvailableLectures(lStartDate, lEndDate, 0);
    }

    @Override
    public List<Lecture> findEnrolledLecturesByUserId(long userId) {
        return lectureEnrollmentRepository.findEnrolledLecturesByUserId(userId);
    }
}
