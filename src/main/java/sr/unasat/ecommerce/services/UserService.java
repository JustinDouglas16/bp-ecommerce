package sr.unasat.ecommerce.services;

import jakarta.persistence.TypedQuery;
import sr.unasat.ecommerce.config.JPAConfiguration;
import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.repositories.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository repository;

    public UserService() {
        this.repository = new UserRepository(JPAConfiguration.getEntityManager());
    }

    public User createUser(User user) {
        return repository.createUser(user);
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public User findUserById(int userId) {
        return repository.getUserById(userId);
    }
}
