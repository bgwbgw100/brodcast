package bgw.crawling.brodcast.internetbordcast;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class BroadcastScheduled {

    private final BroadcastService broadcastService;

    @Getter
    private LocalDateTime  nextResourceTime;

    @Scheduled(fixedRate = 60000)
    public void getBrodCastDTO(){

        List<BroadcastDTO> newResource = broadcastService.getBrodCastList();
        BroadcastResource.setResource(newResource);
        LocalDateTime now = LocalDateTime.now();
        nextResourceTime = now.plusSeconds(60);


    }

}
