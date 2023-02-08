package DanilaZaytsev.car_numbers.numberGeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class NumberGenerationService {

    long current_id;

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public NumberGenerationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getRandom() {
        String number = jdbcTemplate.queryForObject("select car_number from numbers_table order by random() limit 1",
                String.class);
        this.current_id = jdbcTemplate.queryForObject("select id from numbers_table where car_number = ?",
                Long.class, number);
        return number;
    }

    public String getNext() {
        String number = jdbcTemplate.queryForObject("select car_number from numbers_table where id = ?",
                String.class, current_id + 1);
        this.current_id += 1;
        return number;
    }
}