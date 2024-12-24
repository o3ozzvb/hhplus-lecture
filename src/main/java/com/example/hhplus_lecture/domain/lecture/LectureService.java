package com.example.hhplus_lecture.domain.lecture;

import com.example.hhplus_lecture.support.exception.BusinessException;
import com.example.hhplus_lecture.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final LectureEnrollmentRepository lectureEnrollmentRepository;

    /** 특강 신청하기 */
    @Transactional
    public void enrollIn(long userId, long lectureId) {
        LectureEnrollments lectureEnrollments = new LectureEnrollments(lectureEnrollmentRepository.findBy(userId, lectureId));

        Lecture lecture = lectureRepository.findById(lectureId);
        // 특강 여석이 있는지
        if (lecture.isFull()) {
            throw new BusinessException(ErrorCode.LECTURE_FULL);
        }
        // 동일 사용자가 동일 특강에 신청한 내역이 있는지
        if (lectureEnrollments.isEnrollmentExists(userId, lectureId)) {
            throw new BusinessException(ErrorCode.DUPLICATE_REGISTRATION);
        }

        // 여석 차감
        lecture.decreseRemainSeats();
        lectureRepository.save(lecture);

        lectureEnrollmentRepository.save(LectureEnrollment.of(userId, lectureId));
    }

    public List<Lecture> getLecturesByDate(String startDate, String endDate) {
        return null;
    }
}
