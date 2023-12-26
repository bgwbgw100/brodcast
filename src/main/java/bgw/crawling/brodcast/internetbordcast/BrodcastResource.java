package bgw.crawling.brodcast.internetbordcast;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



public class BrodcastResource {
    @Getter
    @Setter
    private static List<BrodcastDTO> resource = new ArrayList<>();

    private BrodcastResource(){}


}
