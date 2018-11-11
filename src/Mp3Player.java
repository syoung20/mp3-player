import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Mp3Player extends JFrame {

    private HashMap<String, Integer> library;
    public Playlist mySongs;
    private ArrayList<Mp3> players;
    private int songsAdded = 0;
    private int songsPlayed = 0;
    boolean IS_PLAYING = false;
    public Playlist test;

    public Mp3Player() {

        super("MP3 Player");
        library = new HashMap<>();
        mySongs = new Playlist();
        players = new ArrayList<>();
        test = new Playlist();
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
                        players.get(library.get(mySongs.get(p.getCurrent()))).play();
                        if (IS_PLAYING) {
                            p.addCurrent();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("No songs to play");
                        break;
                    }
                }
            }
        }
        runner toPlay = new runner();
        Thread playing = new Thread(toPlay);
        if (!IS_PLAYING) {
            IS_PLAYING = true;
            playing.start();
        }
    }

    public void stopSong(Playlist p) {
        if (IS_PLAYING) {
            IS_PLAYING = false;
            players.get(library.get(mySongs.get(p.getCurrent()))).close();

        }
    }

    public void nextSong(Playlist p) {
        if (IS_PLAYING) {
            stopSong(p);
        }
        p.addCurrent();
        playSong(p);
    }

    public void prevSong(Playlist p) {
        if (IS_PLAYING) {
            stopSong(p);
        }
        p.subtractCurrent();
        playSong(p);

    }
}