package pl.sda.pol92.console;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Names {
    final Config config;
    private List<String> names = List.of(
            "Karol",
            "Ewa",
            "Ola",
            "Konrad"
    );

    public Names(Config config) {
        this.config = config;
        System.out.println("NAMES");
        System.out.println(this.config.getAuthor());
    }

    public String getByIndex(int index){
        return names.get(index);
    }
}
