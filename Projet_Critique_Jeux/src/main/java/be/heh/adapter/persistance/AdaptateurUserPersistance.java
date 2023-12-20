package be.heh.adapter.persistance;

import be.heh.application.domain.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdaptateurUserPersistance {
        private final JdbcTemplate jdbc;
        public AdaptateurUserPersistance(JdbcTemplate jdbc) {
            this.jdbc = jdbc;
        }
        public void addUserDB(User user) {
            String sql ="INSERT INTO user VALUES (NULL, ?, ?)";
            jdbc.update(sql,
                    user.getUsername(),
                    user.getPassword());
        }
    }

