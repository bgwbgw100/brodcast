package bgw.crawling.brodcast.internetbordcast;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BrodcastRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<BrodcastDTO> findAll(){
        String sql = """ 
                        SELECT *
                        FROM   LIST
                     """;
        List<BrodcastDTO> list = jdbcTemplate.query(sql, (rs, rowNum) -> {

            BrodcastDTO brodcastDTO = new BrodcastDTO();
            brodcastDTO.setName(rs.getString("name"));
            brodcastDTO.setTitle(rs.getString("title"));
            brodcastDTO.setViews(rs.getInt("views"));
            brodcastDTO.setUserId(rs.getString("user_id"));
            brodcastDTO.setPlatForm(rs.getString("plat_form"));
            brodcastDTO.setUpdateDt(rs.getDate("update_dt"));
            return brodcastDTO;
        });
        return list;
    }




}
