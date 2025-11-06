package com.wowraid.jobspoon.studyschedule.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AttendanceStatus {
    PENDING("대기중"),        // 대기
    ATTENDED("참석"),       // 참석
    ABSENT("불참");          // 불참

    private final String koreanAttendanceStatus;

}
