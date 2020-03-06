package application.annotatedClasses;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Scope("prototype")
public class RetrowaveMusic implements Music {
    private static List<String> songs = new ArrayList<>();
    static {
        songs.add("Rimft - track number one");
        songs.add("Green neon - Tornado");
        songs.add("Duseg - my soul");
    }
    @Override
    public String getSong()
    {
        return songs.get(new Random().nextInt(songs.size()));
    }
}
