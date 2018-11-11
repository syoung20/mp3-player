/**
import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private HashMap<String, Integer> library;


    int ref;

    public Library() {

        library = new HashMap<>();

        mySongs = new Playlist();
        ref = 0;

    }

    public void add(String title, String filename) {


        ref += 1;

    }

    public void delete(String title) {

        if (ref > 0) {

            Integer toDelete = library.get(title);
            library.remove(title);
            players.remove(toDelete);
            mySongs.delete(title);
            ref -= 1;

        } else {

            System.out.println("No songs to delete");

        }

    }



}
*/