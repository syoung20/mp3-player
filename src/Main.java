import javax.swing.*;

public class Main {

    static UserInterface ui;

    public static void main(String[] args) {

        Mp3Player mp3Player = new Mp3Player();
        mp3Player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui = new UserInterface(mp3Player);
        mp3Player.add(ui);
        mp3Player.pack();
        mp3Player.setVisible(true);

    }
}
