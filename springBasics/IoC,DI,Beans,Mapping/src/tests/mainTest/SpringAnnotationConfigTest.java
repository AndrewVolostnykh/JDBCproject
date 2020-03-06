package mainTest;

import application.annotatedClasses.Player;
import application.annotatedClasses.RetrowaveMusic;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.TestCase.*;

public class SpringAnnotationConfigTest {

    @Test
    public void annotatedClassesTest()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotatedClassesContext.xml");
        Player player = context.getBean("player", Player.class);
        player.playMusic(Player.Genres.CLASSICAL);

        System.out.println("Name of player: " + player.getName());
        System.out.println("Established volume to play: " + player.getVolume());


        assertNotNull(player);
        assertNotNull(player.getName());

        context.close();
    }

    /**Checking how @Scope(prototype) working*/
    @Test
    public void scopeTest()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotatedClassesContext.xml");

        RetrowaveMusic retrowaveMusic = context.getBean("retrowaveMusic", RetrowaveMusic.class);
        System.out.println(retrowaveMusic.getSong());

        RetrowaveMusic retrowave = context.getBean("retrowaveMusic", RetrowaveMusic.class);
        System.out.println(retrowave.getSong());

        System.out.println(retrowave == retrowaveMusic);

        assertTrue(retrowave.hashCode() != retrowaveMusic.hashCode());
        assertNotSame(retrowave, retrowaveMusic);
        context.close();
    }
}
