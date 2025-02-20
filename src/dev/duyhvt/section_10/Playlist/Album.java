package dev.duyhvt.section_10.Playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> playList) {
        if (trackNum >= 1) {
            playList.add(songs.get(trackNum - 1));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);

        if (song == null) {
            return false;
        }

        playList.add(song);
        return true;
    }
}
