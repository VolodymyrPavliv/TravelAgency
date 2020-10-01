package dto;

import java.time.LocalDate;

public class BookingRoom {
    private LocalDate from;
    private LocalDate until;
    private Long roomId;

    public BookingRoom() {
    }

    public BookingRoom(LocalDate from, LocalDate until, Long roomId) {
        this.from = from;
        this.until = until;
        this.roomId = roomId;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
