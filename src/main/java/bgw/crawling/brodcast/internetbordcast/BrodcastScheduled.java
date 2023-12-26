package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class BrodcastScheduled {

    private final BrodcastService brodcastService;

    @Scheduled(fixedRate = 60000)
    public void getBrodCastDTO(){
        log.info("스케줄러실행");
        List<BrodcastDTO> newResource = brodcastService.getBrodCastList();
        BrodcastResource.getResource().clear();
        BrodcastResource.setResource(newResource);

        newResource.forEach(brodcastDTO -> log.info(brodcastDTO.toString()));
    }

}
