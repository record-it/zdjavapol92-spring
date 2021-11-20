package pl.sda.pol92.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {
    //@Autowired - wstrzykiwanie przez pole
    final Names names;

    @Autowired
    Random random;

    //wstrzykiwanie przez konstruktor - zalecane
    public ConsoleApplication(Names names) {
        this.names = names;

    }

    //Names names = new Names();
    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from Spring!");
        //System.out.println(names.getByIndex(config.getDefaultIndex()));
        System.out.println(random.nextInt());
    }
}
