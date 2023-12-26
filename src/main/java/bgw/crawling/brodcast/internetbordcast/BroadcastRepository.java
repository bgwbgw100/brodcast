package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BroadcastRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<BroadcastDTO> findAll(){
        String sql = """ 
                        SELECT *
                        FROM   LIST
                     """;
        List<BroadcastDTO> list = jdbcTemplate.query(sql, (rs, rowNum) -> {

            BroadcastDTO brodcastDTO = new BroadcastDTO();
            brodcastDTO.setName(rs.getString("name"));
            brodcastDTO.setTitle(rs.getString("title"));
            brodcastDTO.setViews(rs.getInt("views"));
            brodcastDTO.setUserId(rs.getString("user_id"));
            brodcastDTO.setPlatForm(rs.getString("plat_form"));
            brodcastDTO.setUpdateDt(rs.getDate("update_dt"));
            brodcastDTO.setTag(rs.getString("tag"));
            return brodcastDTO;
        });
        return list;
    }




}
