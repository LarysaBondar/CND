package info.bondar.user.infrastructure.out;

import info.bondar.user.domain.User;
import info.bondar.user.domain.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public void save(User user) {
        Long id = idCounter++;
        user.setId(id);
        users.put(id, user);
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }
}