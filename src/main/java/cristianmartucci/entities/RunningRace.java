package cristianmartucci.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("running_race")
public class RunningRace extends Event {
    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;

    @ManyToMany
    @JoinTable(name = "running_race_people",
            joinColumns = @JoinColumn(name = "running_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "person_id", nullable = false))
    private List<Person> people;

    public RunningRace() {
    }

    public RunningRace(String title, LocalDate event_date, String description, EventType event_type, int max_people, Location location, Person person) {
        super(title, event_date, description, event_type, max_people, location);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "RunningRace{" +
                "person=" + person +
                '}';
    }
}
