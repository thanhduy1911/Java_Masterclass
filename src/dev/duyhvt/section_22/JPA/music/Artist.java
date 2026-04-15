package dev.duyhvt.section_22.JPA.music;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Entity
@Table(name = "artists")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "artist_id")
  private Integer artistId;

  @Column(name = "artist_name")
  private String artistName;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "artist_id")
  private List<Album> albums = new ArrayList<>();

  public void addAlbum(String albumName) {
    albums.add(new Album(albumName));
  }

  public void removeDuplicates() {
    var set = new TreeSet<>(albums);
    albums.clear();
    albums.addAll(set);
  }

  public Artist(String artistName) {
    this.artistName = artistName;
  }
}
