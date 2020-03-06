package application.annotationJavaMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private String model;
    @Autowired
    private Engine engine;
    @Autowired
    private Wheels wheels;

    public Car() {}


    public Car(String model, Engine engine, Wheels wheels)
    {
        this.model = model;
        this.engine = engine;
        this.wheels = wheels;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }
}
