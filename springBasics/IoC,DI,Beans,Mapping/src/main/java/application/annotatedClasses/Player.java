package application.annotatedClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("player")
public class Player {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPLayer.volume}")
    private int volume;

    //@Autowired
    private Music firstTrack;
    private Music secondTrack;
//
//    @PostConstruct
//    public void initMethod()
//    {
//        System.out.println("This class have been initialized");
//    }

    @Autowired
    public Player(@Qualifier("retrowaveMusic") Music music1,
                  @Qualifier("classical_music") Music music2)
    {
        firstTrack = music1;
        secondTrack = music2;
    }

    public void playMusic(Genres genres)
    {
        if (genres == Genres.RETROWAVE)
        {
            System.out.println("Playing: "+firstTrack.getSong());
        } else if (genres == Genres.CLASSICAL)
        {
            System.out.println("Playing: " + secondTrack.getSong());
        } else {
            System.out.println("Genre have no chosen!");
        }
    }

    public enum Genres
    {
        RETROWAVE,
        CLASSICAL
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
