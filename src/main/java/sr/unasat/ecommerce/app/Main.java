package sr.unasat.ecommerce.app;

import sr.unasat.ecommerce.entities.User;
import sr.unasat.ecommerce.services.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

        User user = new User();
//        user.setName("Peter");
//        user.setPassword("789");
//        user.setEmail("peter@bitdynamics.sr");

//        service.createUser(user);
//        user.setId(2);
//        service.deleteUser(user);

        user.setId(3);
        user.setName("John");
        service.updateUser(user);

//        List<User> users = service.getUsers();
//        users.forEach(user -> System.out.println("Name = " + user.getName() + " " + "Password = " + user.getPassword() + " " + "Email = " + user.getEmail()));
    }
}
