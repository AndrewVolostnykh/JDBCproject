package application.xmlMappedClasses;

import application.xmlMappedClasses.Music;

public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Rock track";
    }
}
