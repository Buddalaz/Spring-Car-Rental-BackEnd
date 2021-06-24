package lk.easycarrentalpvt.spring.repo;

import lk.easycarrentalpvt.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    Optional<User> findUserByUserNameAndPassword(String username, String password);

}
