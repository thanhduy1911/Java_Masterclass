package dev.duyhvt.section_22.JPA;

import dev.duyhvt.section_22.JPA.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainQuery {
  public static void main(String[] args) {

    List<Artist> artists = null;
    try (EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dev.duyhvt.section_22.JPA.music");
        EntityManager em = emf.createEntityManager()) {
      var transaction = em.getTransaction();
      transaction.begin();
      artists = getArtists(em, "%Stev%");
      artists.forEach(System.out::println);
      transaction.commit();
    }
  }

  private static List<Artist> getArtists(EntityManager em, String matchedValue) {
    String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE ?1";
    var query = em.createQuery(jpql, Artist.class);
    query.setParameter(1, matchedValue);
    return query.getResultList();
  }
}
