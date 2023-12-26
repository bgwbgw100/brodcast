package bgw.crawling.brodcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BrodcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrodcastApplication.class, args);
	}

}
