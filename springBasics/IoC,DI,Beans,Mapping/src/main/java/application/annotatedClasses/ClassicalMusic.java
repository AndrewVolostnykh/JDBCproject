package application.annotatedClasses;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("classical_music")
public class ClassicalMusic implements Music{

    private static List<String> songs = new ArrayList<>();
    static {
        songs.add("Vivaldi - winter");
        songs.add("Beethoven - fur elise");
        songs.add("Unknown - march 5");
    }

    @Override
    public String getSong()
    {
        return songs.get(new Random().nextInt(songs.size()));
    }
}
