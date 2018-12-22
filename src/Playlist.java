import java.util.ArrayList;

public class Playlist {

    private ArrayList<String> playlist;
    int current = 0;

    public Playlist() {

        playlist = new ArrayList<>();

    }

    public String get(int d) {

        return playlist.get(d);

    }

    public String getCurrentSong() {

        if (!playlist.isEmpty()) {

            return (playlist.get(current))
        }

        return null;

    }

    //sets current song counter to the next song
    public void setNext() {
        if (current == playlist.size() - 1) {
            current = 0;
        } else {
            current += 1;
        }
    }

    //sets current song counter to the previous song
    public void setPrev() {
        if (current > 0) {
            current -= 1;
        }
    }

    //add a song to the playlist
    public void add(String title) {

        playlist.add(title);

    }

    //delete a song from the playlist
    public void delete(String title) {

        playlist.remove(title);

    }

    //add a song to the playlist at a specific index
    public void add(String title, int placement) {

        playlist.add(placement, title);

    }

}
