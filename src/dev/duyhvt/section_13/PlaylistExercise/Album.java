package dev.duyhvt.section_13.PlaylistExercise;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            songs = new ArrayList<Song>();
        }

        private boolean add(Song songtoAdd) {
            if (songs.contains(songtoAdd)) {
                return false;
            }
            songs.add(songtoAdd);
            return true;
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index <= songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        if (songs.findSong(trackNumber) != null) {
            playlist.add(songs.songs.get(trackNumber - 1));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        if (songs.findSong(title) != null) {
            Song song = songs.findSong(title);
            if (song != null) {
                playlist.add(song);
                return true;
            }
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
