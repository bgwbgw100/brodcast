package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class BrodcastController {

    private final BrodcastService brodcastService;

    @GetMapping("main")
    public void main(){

    }

}
