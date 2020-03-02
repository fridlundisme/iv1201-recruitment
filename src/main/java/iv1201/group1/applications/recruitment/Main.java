package iv1201.group1.applications.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class Main {
    
    /** Starts the Spring Boot application
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
