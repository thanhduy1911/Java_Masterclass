package dev.duyhvt.section_22.JPA;

import dev.duyhvt.section_22.JPA.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    try (var sessionFactory =
        Persistence.createEntityManagerFactory("dev.duyhvt.section_22.JPA.music")) {
      try (EntityManager entityManager = sessionFactory.createEntityManager()) {
        var transaction = entityManager.getTransaction();
        transaction.begin();
        var artist = entityManager.find(Artist.class, 202);
        System.out.println(artist);
        artist.addAlbum("The Best of Muddy Waters");
        // artist.removeDuplicates();
        System.out.println(artist);
        // entityManager.remove(artist);
        // entityManager.persist(new Artist("Muddy Waters"));
        // entityManager.merge(artist);
        transaction.commit();
      }
    }
  }
}
