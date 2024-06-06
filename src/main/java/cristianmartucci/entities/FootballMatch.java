package cristianmartucci.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("football_match")
@NamedQuery(name = "getWinnerHomeMatch", query = "SELECT f FROM FootballMatch f WHERE f.winner_team = f.home_team")
@NamedQuery(name = "getWinnerVisitingMatch", query = "SELECT f FROM FootballMatch f WHERE f.winner_team = f.visiting_team")
public class FootballMatch extends Event {
    private String home_team;
    private String visiting_team;
    private String winner_team;
    private int goal_home_team;
    private int goal_visiting_team;

    public FootballMatch() {
    }

    public FootballMatch(String title, LocalDate event_date, String description, EventType event_type, int max_people, Location location, String home_team, String visiting_team, String winner_team, int goal_home_team, int goal_visiting_team) {
        super(title, event_date, description, event_type, max_people, location);
        this.home_team = home_team;
        this.visiting_team = visiting_team;
        this.winner_team = winner_team;
        this.goal_home_team = goal_home_team;
        this.goal_visiting_team = goal_visiting_team;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getVisiting_team() {
        return visiting_team;
    }

    public void setVisiting_team(String visiting_team) {
        this.visiting_team = visiting_team;
    }

    public String getWinner_team() {
        return winner_team;
    }

    public void setWinner_team(String winner_team) {
        this.winner_team = winner_team;
    }

    public int getGoal_home_team() {
        return goal_home_team;
    }

    public void setGoal_home_team(int goal_home_team) {
        this.goal_home_team = goal_home_team;
    }

    public int getGoal_visiting_team() {
        return goal_visiting_team;
    }

    public void setGoal_visiting_team(int goal_visiting_team) {
        this.goal_visiting_team = goal_visiting_team;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                "home_team='" + home_team + '\'' +
                ", visiting_team='" + visiting_team + '\'' +
                ", winner_team='" + winner_team + '\'' +
                ", goal_home_team=" + goal_home_team +
                ", goal_visiting_team=" + goal_visiting_team +
                '}';
    }
}
