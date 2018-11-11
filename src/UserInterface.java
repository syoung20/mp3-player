import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JPanel implements ActionListener {

    JButton prev;
    JButton next;
    JButton play;
    JButton lists;
    JButton seeLib;
    JLabel nowplaying;
    JButton stop;
    Mp3Player mp3Player;
    public Playlist currentPlaylist;

    public UserInterface(Mp3Player p) {

        mp3Player = p;
        setSize(300, 200);
        lists = new JButton("See playlists:");
        prev = new JButton("Prev");
        next = new JButton("Next");
        play = new JButton("Play");
        nowplaying = new JLabel("Now Playing:");
        seeLib = new JButton("See library:");
        stop = new JButton("Stop");

        lists.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);
        play.addActionListener(this);
        seeLib.addActionListener(this);
        stop.addActionListener(this);

       // add(lists);
        add(prev);
        add(play);
        add(stop);
        add(next);
        //add(nowplaying);
       // add(seeLib);

        mp3Player.addSong("DBJ Performance", "/Users/Sarah/Desktop/DBJ/DBJ Performance.mp3");
        mp3Player.addSong("Retrograde", "/Users/Sarah/Desktop/Retrograde - Intersections Spring 2017.mp3");
        mp3Player.addSong("2018", "/Users/Sarah/Desktop/2018 new set.mp3");
        //create function to add songs to mp3 player library
        currentPlaylist = mp3Player.mySongs;
        //create function to add playlists
        //create function to add songs to playlists
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == play) {
            mp3Player.playSong(currentPlaylist);
        }

        if (source == stop) {
            mp3Player.stopSong(currentPlaylist);
        }

        if (source == next) {
            mp3Player.nextSong(currentPlaylist);
        }

        if (source == prev) {
            mp3Player.prevSong(currentPlaylist);
        }

        if (source == seeLib) {
            // need to fill
        }

        if (source == lists) {
            //need to fill
        }

    }
}