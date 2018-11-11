import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Mp3 {

    String filename;
    Player player;

    public Mp3(String filename) {

        this.filename = filename;

    }

    public void play() {

        try {

            FileInputStream fileStream = new FileInputStream(filename);
            BufferedInputStream bufferedStream = new BufferedInputStream(fileStream);
            player = new Player(bufferedStream);
            player.play();

        }

        catch (Exception ex) {

            System.out.println("Problem playing file " + filename);
            System.out.println(ex);
        }


    }

    public void close() {

        if (player != null) {

            player.close();
        }
    }

}
