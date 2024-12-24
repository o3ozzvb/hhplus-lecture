package com.example.hhplus_lecture.support.exception;

public enum ErrorCode {
    LECTURE_FULL("LECTURE_FULL", "강의 정원을 초과하여 신청할 수 없습니다."),
    DUPLICATE_REGISTRATION("DUPLICATE_REGISTRATION", "이미 신청한 강의입니다."),
    LECTURE_NOT_EXIST("LECTURE_NOT_EXIST", "존재하지 않는 강의입니다."),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "서버 에러 입니다.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
