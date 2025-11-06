package com.wowraid.jobspoon.studyschedule.service.response;

import com.wowraid.jobspoon.studyschedule.entity.AttendanceStatus;
import com.wowraid.jobspoon.studyschedule.entity.ScheduleAttendance;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ListAttendanceStatusResponse {
    private final Long studyMemberId;
    private final String nickname;
    private final String status;

    private ListAttendanceStatusResponse(ScheduleAttendance attendance) {
        this.studyMemberId = attendance.getStudyMember().getId();
        this.nickname = attendance.getStudyMember().getAccountProfile().getNickname();
        this.status = attendance.getStatus().getKoreanAttendanceStatus();
    }

    public static ListAttendanceStatusResponse from(ScheduleAttendance attendance) {
        return new ListAttendanceStatusResponse(attendance);
    }
}