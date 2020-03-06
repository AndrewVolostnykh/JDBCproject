package application.annotationJavaMapping;

import org.springframework.stereotype.Component;

@Component
public class Engine implements Parts {

    String engineName = "Engine";

    @Override
    public String getPartName() {
        return engineName;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }
}
