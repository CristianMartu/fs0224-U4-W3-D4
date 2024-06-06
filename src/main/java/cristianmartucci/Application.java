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
        ld.save(location);

        LocalDate date = LocalDate.of(2024, 5, 7);
        Event event = new Event("Eurovision Song Contest 2024", date, "L'Eurovision Song Contest 2024 è stata la 68ª edizione dell'annuale concorso canoro, vinta dal cantante svizzero Nemo con la canzone The Code.", EventType.PRIVATO, 13700, location);
//        Event event2 = new Event("Run 5.30", LocalDate.parse("2024-06-06"), "Evento pubblico", EventType.PUBBLICO, 3000, location2);
        ed.save(event);

        Person person = new Person("Geralt", "Of Rivia", "geraltOfRivia@gmail.com", LocalDate.parse("1964-02-06"), GenderType.MASCHIO);
        personDao.save(person);


//        Event eventFromDb = ed.getById("de646ccc-9102-4b73-a8f8-b80af4004dba");
//        Person personFromDb = personDao.getById("31ace7fd-3264-4757-9296-759cf97cced5");
        // Participation participation = new Participation(ParticipationState.CONFERMATA, eventFromDb, personFromDb);
        //pd.save(participation);

//        try {
//            Location getLocation = ld.getById("a642a338-f330-4aaa-96c5-7ec08f562f7d");
//            System.out.println(getLocation);
//        } catch (EventException error) {
//            System.out.println(error.getMessage());
//        }
//
//        try {
//            Event getEvent = ed.getById("ac6c1338-9321-4b30-b4ad-18a54429f8b1");
//            System.out.println(getEvent);
//        } catch (EventException error) {
//            System.out.println(error.getMessage());
//        }
//
//        try {
//            Person getPerson = personDao.getById("8944caba-e2d8-4a6e-b14c-300069d07cba");
//            System.out.println(getPerson);
//        } catch (EventException error) {
//            System.out.println(error.getMessage());
//        }

//        try {
//            Participation getParticipation = pd.getById("faf55416-d5c4-4211-b73c-12459aaa62d2");
//            System.out.println(getParticipation);
//        } catch (EventException error) {
//            System.out.println(error.getMessage());
//        }


        em.close();
        emf.close();
    }
}
