package sr.unasat.ecommerce.app;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

//        User user = new User();
//        user.setName("Peter");
//        user.setPassword("789");
//        user.setEmail("peter@bitdynamics.sr");

//        service.createUser(user);

//        user.setId(2);
//        service.deleteUser(user);

//        user.setId(4);
//        user.setName("Bruce");
//        user.setPassword("123");
//        user.setEmail("bruce@bruce.org");
//        service.updateUser(user);

//        String name = "John";
//        user.setName(name);

//        service.getUserByName("John");
//        System.out.println(service);

//        service.getUserById(3);
//        System.out.println();

//        List<User> users = service.getUsers();
//        users.forEach(user -> System.out.println("Name = " + user.getName() + " " + "Password = " + user.getPassword() + " " + "Email = " + user.getEmail()));

        User userById = service.getUserById(3);
        if (userById != null) {
            System.out.println("User by ID: " + userById);
        } else {
            System.out.println("User not found for ID 3");
        }
    }
}
