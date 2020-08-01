package nhom7.thh.meomeonoteserver.repository;

import nhom7.thh.meomeonoteserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);
}
