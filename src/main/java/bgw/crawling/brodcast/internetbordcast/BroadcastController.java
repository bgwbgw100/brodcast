package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class BroadcastController {

    private final BroadcastService brodcastService;

    @GetMapping("main")
    public void main(){
    }
    @GetMapping("list")
    @ResponseBody
    public List<BroadcastDTO> brodcastList (){
        return BroadcastResource.getResource();
    }

}
