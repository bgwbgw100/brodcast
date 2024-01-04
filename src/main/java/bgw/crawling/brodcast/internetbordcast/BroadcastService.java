package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BroadcastService {
    private final BroadcastRepository broadcastRepository;

    @Transactional
    public List<BroadcastDTO> getBrodCastList(){

        return broadcastRepository.findAll();
    }

    public void   temp(){
        broadcastRepository.temp();

    }

}
