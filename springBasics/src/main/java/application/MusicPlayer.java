package application;

public class MusicPlayer {
    private String name;
    private int volume;

    private Music music;

    // IoC arch
    public MusicPlayer(Music music)
    {
        this.music = music;
    }

    public MusicPlayer(){} // because xml crying

    public void setMusic(Music music)
    {
        this.music = music;
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

    public void playMusic()
    {
        System.out.println("Playing: " + music.getSong());
    }
}
