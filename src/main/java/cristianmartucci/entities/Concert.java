package cristianmartucci.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("concert")
public class Concert extends Event {
    private ConcertType concert_type;
    private boolean in_streaming;

    public Concert() {
    }

    public Concert(String title, LocalDate event_date, String description, EventType event_type, int max_people, Location location, ConcertType concert_type, boolean in_streaming) {
        super(title, event_date, description, event_type, max_people, location);
        this.concert_type = concert_type;
        this.in_streaming = in_streaming;
    }

    public ConcertType getConcert_type() {
        return concert_type;
    }

    public void setConcert_type(ConcertType concert_type) {
        this.concert_type = concert_type;
    }

    public boolean isIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(boolean in_streaming) {
        this.in_streaming = in_streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "concert_type=" + concert_type +
                ", in_streaming=" + in_streaming +
                '}';
    }
}
