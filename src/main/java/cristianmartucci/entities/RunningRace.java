package cristianmartucci.entities;

import jakarta.persistence.*;

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
}
