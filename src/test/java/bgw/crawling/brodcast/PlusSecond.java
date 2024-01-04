package bgw.crawling.brodcast;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;


public class PlusSecond {


    @Test
    void plusSecond() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime plusSecond = now.plusSeconds(60);
        Duration between = Duration.between(now, plusSecond);
        Assertions.assertTrue(between.getSeconds()>=0);
    }

}
