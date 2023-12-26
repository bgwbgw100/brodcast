package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
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

    //추후 테스트 코드를 만들때 옮길예정??
    public void temp(){
        jdbcTemplate.query("""
                    SHOW VARIABLES LIKE 'wait_timeout'
                """,rs -> {
            log.info(rs.getString("variable_name" ));
            log.info(rs.getString("Value" ));
        });
    }




}
