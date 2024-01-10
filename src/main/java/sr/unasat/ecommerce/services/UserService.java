package sr.unasat.ecommerce.services;

import sr.unasat.ecommerce.config.JPAConfiguration;
import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.repositories.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository repository;

    public UserService() {
        this.repository = new UserRepository(JPAConfiguration.getEntityManager());
    }

    public void getUserByName(String name) {
        repository.getUserByName(name);
    }

    public void updateUser(User user) {
        repository.updateUser(user);
    }

    public boolean deleteUser(User user) {
        return repository.deleteUser(user);
    }

    public User createUser(User user) {
        return repository.createUser(user);
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }
}
