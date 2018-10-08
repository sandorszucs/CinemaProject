import java.util.List;

public class Cinema {

    private RegisteredUser registeredUser;
    private Schedule schedule;
    private List<Hall> Hall;

    public Cinema(RegisteredUser registeredUser, Schedule schedule, List<Hall> hall) {
        this.registeredUser = registeredUser;
        this.schedule = schedule;
        Hall = hall;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
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



