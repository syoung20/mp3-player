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

    public int getCurrent() {

        int toReturn;

        if (playlist.isEmpty()) {
            toReturn = -1;
        }

        else {
            toReturn = current;
        }

        return toReturn;

    }

    public void addCurrent() {
        if (current == playlist.size() - 1) {
            current = 0;
        } else {
            current += 1;
        }
    }

    public void subtractCurrent() {
        if (current > 0) {
            current -= 1;
        }
    }

    public void add(String title) {

        playlist.add(title);

    }

    public void delete(String title) {

        playlist.remove(title);

    }

    public void add(String title, int placement) {

        playlist.add(placement, title);

    }

    public void move(String title, int placement) {



    }
}
