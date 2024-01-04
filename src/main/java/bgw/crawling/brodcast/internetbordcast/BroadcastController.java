package bgw.crawling.brodcast.internetbordcast;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class BroadcastController {

    private final BroadcastService broadcastService;

    private final BroadcastScheduled broadcastScheduled;

    @GetMapping(value = {"main","/","index"})
    public String main(){
        return "main";
    }

    @GetMapping("list")
    @ResponseBody
    public ResponseEntity<List<BroadcastDTO>> broadcastList (){
        LocalDateTime nextResourceTime = broadcastScheduled.getNextResourceTime();
        LocalDateTime now = LocalDateTime.now();
        Duration cacheTime = Duration.between(now, nextResourceTime);
        CacheControl cacheControl = CacheControl.maxAge(cacheTime.getSeconds(), TimeUnit.SECONDS);
        return ResponseEntity.ok().cacheControl(cacheControl).body(BroadcastResource.getResource());
    }

}
