package application.annotationJavaMapping;

import org.springframework.stereotype.Component;

@Component
public class Wheels implements Parts {

    String partName = "wheels";

    @Override
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }


}
