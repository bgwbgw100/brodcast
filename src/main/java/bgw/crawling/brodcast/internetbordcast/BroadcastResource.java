package bgw.crawling.brodcast.internetbordcast;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



public class BroadcastResource {
    @Getter
    @Setter
    private static List<BroadcastDTO> resource = new ArrayList<>();

    private BroadcastResource(){}


}
