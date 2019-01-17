package org.project.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cinema")
public class Cinema {


    private User user;
    private Schedule schedule;
    private List<Hall> hall;

    public Cinema(User user, Schedule schedule, List<Hall> hall) {
        this.user = user;
        this.schedule = schedule;
        this.hall = hall;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule)
    {
        this.schedule = schedule;
    }

    public List<Hall> getHall() {
        return hall;
    }

    public void setHall(List<Hall> hall) {
        hall = hall;
    }
}



