package application.xmlMappedClasses;

import application.xmlMappedClasses.Music;

public class PopMusic implements Music {

    @Override
    public String getSong() {
        return "Pop track";
    }
}
