package mainTest;

import application.annotationJavaMapping.Car;
import application.annotationJavaMapping.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static junit.framework.TestCase.assertNotNull;

public class SpringJavaAnnotationMappingTast {
    @Test
    public void test()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Car car = context.getBean("car", Car.class);
        car.setModel("first my spring world car-x50");

        System.out.println(car.getEngine().getPartName());
        System.out.println(car.getWheels().getPartName());
        System.out.println(car.getModel());

        assertNotNull(car);
        context.close();
    }

}
