package bgw.crawling.brodcast.internetbordcast;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BroadcastDTO {
    String platForm;
    String userId;
    String name;
    String title;
    int views;
    Date updateDt;
    String tag;
}
