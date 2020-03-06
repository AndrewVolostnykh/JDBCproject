package application.xmlMappedClasses;

import application.xmlMappedClasses.Music;
import org.springframework.stereotype.Component;

@Component("rap_music")
public class RapMusic implements Music {

    @Override
    public String getSong() {
        return "Rap track";
    }
}
