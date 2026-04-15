package dev.duyhvt.section_22.JPA.music;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "albums")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Comparable<Album> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "album_id")
  private Integer albumId;

  @Column(name = "album_name")
  private String albumName;

  public Album(String albumName) {
    this.albumName = albumName;
  }

  @Override
  public int compareTo(Album o) {
    return this.albumName.compareTo(o.getAlbumName());
  }
}
