package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BroadcastService {
    private final BroadcastRepository brodcastRepository;

    public List<BroadcastDTO> getBrodCastList(){

        return brodcastRepository.findAll();
    }

    public void   temp(){
        brodcastRepository.temp();

    }

}
