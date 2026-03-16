interface Playable {
    void play();
}

class MusicPlayer implements Playable {
    String songName;

    MusicPlayer(String songName) {
        this.songName = songName;
    }

    @Override
    public void play() {
        System.out.println("Playing song: " + songName);
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer("Believer");
        player.play();
    }
}

/*
 * WHY THIS IS A GOOD INTERFACE EXAMPLE
 * 1) Playable describes a capability: "can play".
 * 2) It does not care what the object is.
 * 3) A music player, video player, or game can all be Playable.
 * 4) The interface gives a common rule: every Playable object must define play().
 *
 * IMPORTANT RULES
 * 1) An interface is used to define behavior that classes promise to implement.
 * 2) A class uses the keyword "implements" with an interface.
 * 3) We cannot create an object of an interface directly.
 * 4) The class implementing the interface must define its methods.
 */
