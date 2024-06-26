package cristianmartucci;

import cristianmartucci.dao.EventDAO;
import cristianmartucci.dao.LocationDAO;
import cristianmartucci.dao.ParticipationDAO;
import cristianmartucci.dao.PersonDAO;
import cristianmartucci.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myEvent");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonDAO personDao = new PersonDAO(em);
        ParticipationDAO pd = new ParticipationDAO(em);

        Location location = new Location("Teatro Ariston", "Sanremo");
//        Location location2 = new Location("Centro città", "Modena");
//        ld.save(location);

        LocalDate date = LocalDate.of(2024, 5, 7);
        Event event = new Event("Eurovision Song Contest 2024", date, "L'Eurovision Song Contest 2024 è stata la 68ª edizione dell'annuale concorso canoro, vinta dal cantante svizzero Nemo con la canzone The Code.", EventType.PRIVATO, 13700, location);
//        Event event2 = new Event("Run 5.30", LocalDate.parse("2024-06-06"), "Evento pubblico", EventType.PUBBLICO, 3000, location2);
//        ed.save(event);

        Person person = new Person("Geralt", "Of Rivia", "geraltOfRivia@gmail.com", LocalDate.parse("1964-02-06"), GenderType.MASCHIO);
//        personDao.save(person);

//        Event eventFromDb = ed.getById("de646ccc-9102-4b73-a8f8-b80af4004dba");
//        Person personFromDb = personDao.getById("31ace7fd-3264-4757-9296-759cf97cced5");
        // Participation participation = new Participation(ParticipationState.CONFERMATA, eventFromDb, personFromDb);
        //pd.save(participation);

        FootballMatch footballMatch = new FootballMatch("Partita di calcio", LocalDate.parse("2024-06-12"), "amichevole", EventType.PRIVATO, 30, location, "Milan", "Inter", "Milan", 3, 2);
        //ed.save(footballMatch);

        Location locationFromDb = ld.getById("6166c5fb-c231-4f82-9af5-0e416926a146");
        Concert concert = new Concert("AC/DC", LocalDate.parse("2024-05-23"), "Concerto AC/DC", EventType.PRIVATO, 10000, locationFromDb, ConcertType.ROCK, false);
//        ed.save(concert);

        Person getPersonFromDb = personDao.getById("6bd47231-3464-46fd-ac37-b3482a89722b");
        RunningRace race = new RunningRace("Run 5.30", LocalDate.parse("2024-06-06"), "Evento pubblico", EventType.PUBBLICO, 3000, locationFromDb, getPersonFromDb);
//        ed.save(race);

        ed.getConcertInStreaming(false).forEach(System.out::println);
        ed.getConcertType(ConcertType.ROCK).forEach(System.out::println);
        ed.getWinnerHomeMatch().forEach(System.out::println);
        ed.getWinnerVisitingMatch().forEach(System.out::println);


        em.close();
        emf.close();
    }
}






