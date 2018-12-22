import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Mp3Player extends JFrame {

    //maps mp3 titles to index in players
    private HashMap<String, Integer> library;
    //contains all the songs the user has uploaded
    public Playlist mySongs;
    //contains individual mp3players for each song
    private ArrayList<Mp3> players;
    //counts number of mp3players created in players
    private int songsAdded = 0;
    //counts current index of song being played
    private int songsPlayed = 0;
    //returns true if a song is currently playing
    boolean IS_PLAYING = false;

    public Mp3Player() {

        super("MP3 Player");
        library = new HashMap<>();
        mySongs = new Playlist();
        players = new ArrayList<>();
    }

    public void addSong(String title, String filename) {

        players.add(songsAdded, new Mp3(filename));
        library.put(title, songsAdded);
        mySongs.add(title);
        songsAdded += 1;
    }

    public void playSong(Playlist p) {

        class runner implements Runnable {
            runner() {
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        players.get(library.get(p.getCurrentSong)).play();
                        //if IS_PLAYING is still true (stop was not pressed), set the next song to play
                        if (IS_PLAYING) {
                            p.setNext();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("No songs to play");
                        break;
                    }
                }
            }
        }
        Thread playing = new Thread(new runner());
        if (!IS_PLAYING) {
            IS_PLAYING = true;
            playing.start();
        }
    }

    public void stopSong(Playlist p) {
        if (IS_PLAYING) {
            IS_PLAYING = false;
            players.get(library.get(p.getCurrentSong)).close();

        }
    }

    public void nextSong(Playlist p) {
        if (IS_PLAYING) {
            stopSong(p);
        }
        p.setNext();
        playSong(p);
    }

    public void prevSong(Playlist p) {
        if (IS_PLAYING) {
            stopSong(p);
        }
        p.setPrev();
        playSong(p);

    }
}