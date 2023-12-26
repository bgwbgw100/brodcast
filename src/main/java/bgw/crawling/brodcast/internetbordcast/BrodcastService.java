package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrodcastService {
    private final BrodcastRepository brodcastRepository;

    public List<BrodcastDTO> getBrodCastList(){

        return brodcastRepository.findAll();
    }


}
