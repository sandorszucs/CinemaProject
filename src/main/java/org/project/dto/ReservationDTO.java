package org.project.dto;

import java.util.Date;
import java.util.List;

public class ReservationDTO {

    private long id;

    private long scheduleId;
    private List<String> reservedSeat;
    private Long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<String> getReservedSeat() {
        return reservedSeat;
    }

    public void setReservedSeats(List<String> reservedSeat) {
        this.reservedSeat = reservedSeat;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

