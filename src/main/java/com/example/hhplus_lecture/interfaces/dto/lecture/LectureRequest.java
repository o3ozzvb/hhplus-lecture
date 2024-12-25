package com.example.hhplus_lecture.interfaces.dto.lecture;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LectureRequest {
    @NotBlank
    private String startDate;

    @NotBlank
    private String endDate;
}
