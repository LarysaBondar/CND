package info.bondar.user.domain;


public interface UserRepository {
    void save(User user);
    User findById(Long id);
}