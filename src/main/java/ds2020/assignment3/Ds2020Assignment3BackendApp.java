package ds2020.assignment3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

import java.util.TimeZone;

@SpringBootApplication
@Validated
public class Ds2020Assignment3BackendApp {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(Ds2020Assignment3BackendApp.class, args);
    }
}
