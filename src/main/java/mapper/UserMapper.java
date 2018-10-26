package mapper;

import org.springframework.stereotype.Repository;
import pojo.User;

@Repository
public interface UserMapper {

    User login(User user);
}
