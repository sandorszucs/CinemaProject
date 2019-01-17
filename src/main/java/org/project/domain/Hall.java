package org.project.domain;

import javax.persistence.*;

@Entity
@Table (name = "hall")
public class Hall {

    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "hall_generator")
    @SequenceGenerator(
            name = "hall_generator",
            sequenceName = "hall_sequence",
            initialValue = 1
    )
    private long id;

    @Column (name = "location")
    private String location;

    @Column(name = "capacity")
    private int capacity;

    public Hall(String location, int capacity) {
        this.location = location;
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
