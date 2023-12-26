package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class BroadcastScheduled {

    private final BroadcastService brodcastService;

    @Scheduled(fixedRate = 60000)
    public void getBrodCastDTO(){
        log.info("스케줄러실행");
        List<BroadcastDTO> newResource = brodcastService.getBrodCastList();
        BroadcastResource.setResource(newResource);

    }

}
