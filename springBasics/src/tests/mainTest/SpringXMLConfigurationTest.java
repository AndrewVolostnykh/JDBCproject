package mainTest;

import application.Music;
import application.MusicPlayer;
import application.TestBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.TestCase.assertNotNull;

public class SpringXMLConfigurationTest {

    /**Here tested xml configuration beans for Spring*/
    @Test
    public void firstTest()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());

        assertNotNull(testBean);
        context.close();
    }

    /** Here tested some Inversion of Control.
     * Interface Music have method getSong(),
     * this using when need to play music. In context.xml
     * we have write bean - PopMusic class that have implement of Music
     * and using Music interface we can call player, put in constructor
     * this object (that have created using Music and MusicPop.class)
     * and call method to play music (here - pop)*/
    @Test
    public void musicFirstIoC()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Music music = context.getBean("popBean", Music.class);
        MusicPlayer player = new MusicPlayer(music);
        player.playMusic();

        assertNotNull(music);

        Music rock = context.getBean("rockBean", Music.class);
        player = new MusicPlayer(rock);
        player.playMusic();

        assertNotNull(music);
        context.close();
    }

    /**Testing of Dependency injection. :
     * in context.xml saved musicPlayer beans for rock and pop,
     * and now we dont have to create Music intf object but
     * create with context MusicPlayer and play track*/
    @Test
    public void depInjExample()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MusicPlayer rockPlayer = context.getBean("rockMusicPlayer", MusicPlayer.class);
        rockPlayer.playMusic();

        assertNotNull(rockPlayer);

        rockPlayer = context.getBean("popMusicPlayer", MusicPlayer.class);
        rockPlayer.playMusic();

        assertNotNull(rockPlayer);
        context.close();
    }

    //example of DI using setter
    /**Injection not ref on Music but some values like name or volume*/
    @Test
    public void setterDI()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MusicPlayer player = context.getBean("rockSetMusicPlayer", MusicPlayer.class);
        player.playMusic();

        assertNotNull(player);

        System.out.println(player.getName());
        System.out.println(player.getVolume());

        // here we taking information from properties file
        player = context.getBean("propertiesMusicPlayer", MusicPlayer.class);
        player.playMusic();

        assertNotNull(player);
        assertNotNull(player.getName());

        System.out.println(player.getVolume());
        System.out.println(player.getName());
        context.close();
    }

}
