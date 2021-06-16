package lk.easycarrentalpvt.spring.repo;

import lk.easycarrentalpvt.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
