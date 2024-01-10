package sr.unasat.ecommerce.services;

import sr.unasat.ecommerce.config.JPAConfiguration;
import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.repositories.UserRepository;

public class UserService {
    private final UserRepository repository;

    public UserService() {
        this.repository = new UserRepository(JPAConfiguration.getEntityManager());
    }

    public User createUser(User user) {
        return repository.createUser(user);
    }
}
