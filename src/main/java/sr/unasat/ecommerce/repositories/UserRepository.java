package sr.unasat.ecommerce.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import sr.unasat.ecommerce.entities.User;

import java.util.List;

public class UserRepository {
    private EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @Author Justin
     * @Description Save method
     */
    public User createUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return user;
    }

    public void updateUser(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public boolean deleteUser(User user) {
        try {
            entityManager.getTransaction().begin();
            User mergedUser = entityManager.merge(user); // Ensure the entity is in the managed state
            entityManager.remove(mergedUser);
            entityManager.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    /**
     * @Author Justin
     * @Description Get all users from table
     */
    public List<User> getUsers() {
        String query = "select g from User g";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return typedQuery.getResultList();
    }
}
