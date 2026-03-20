package dev.duyhvt.section_22.JPA.music;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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

  public Artist(String artistName) {
    this.artistName = artistName;
  }
}
