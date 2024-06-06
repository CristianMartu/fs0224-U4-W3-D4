package cristianmartucci.dao;

import cristianmartucci.entities.Concert;
import cristianmartucci.entities.ConcertType;
import cristianmartucci.entities.Event;
import cristianmartucci.entities.FootballMatch;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
    }

    public Event getById(String eventId) {
        Event event = em.find(Event.class, UUID.fromString(eventId));
        if (event == null) throw new EventException(UUID.fromString(eventId));
        return event;
    }

    public void delete(String eventId) {
        Event event = this.getById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(event);
        transaction.commit();
    }

    public List<Concert> getConcertInStreaming(Boolean value) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.in_streaming = :value", Concert.class);
        query.setParameter("value", value);
        return query.getResultList();
    }

    public List<Concert> getConcertType(ConcertType type) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.concert_type = :type", Concert.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<FootballMatch> getWinnerHomeMatch() {
        TypedQuery<FootballMatch> query = em.createQuery("getWinnerHomeMatch", FootballMatch.class);
        return query.getResultList();
    }

    public List<FootballMatch> getWinnerVisitingMatch() {
        TypedQuery<FootballMatch> query = em.createQuery("getWinnerVisitingMatch", FootballMatch.class);
        return query.getResultList();
    }
}
