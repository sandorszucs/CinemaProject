package org.project;
import java.util.List;

public class Cinema {

    private User User;
    private Schedule schedule;
    private List<Hall> Hall;

    public Cinema(User User, Schedule schedule, List<Hall> hall) {
        this.User = User;
        this.schedule = schedule;
        Hall = hall;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Hall> getHall() {
        return Hall;
    }

    public void setHall(List<Hall> hall) {
        Hall = hall;
    }
}



