package application.annotationJavaMapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("application.annotationJavaMapping")
public class SpringConfig {
    /*
    @Bean // we dont need to map this beans, because we using @Autowired
    public Wheels wheels()
    {
        return new Wheels();
    }

    @Bean // we dont need to map this beans, because we using @Autowired
    public Engine engine()
    {
        return new Engine();
    }

    @Bean // we dont need to map this beans, because we using @Autowired
    public Car car()
    {
        return new Car();
    }

     */


}
