package org.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "reserved_seats")
public class ReservedSeat {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "reservedSeats_generator")
    @SequenceGenerator(
            name = "reservedSeats_generator",
            sequenceName = "reservedSeats_sequence",
            initialValue = 1
    )
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Seat seat;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Schedule schedule;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
