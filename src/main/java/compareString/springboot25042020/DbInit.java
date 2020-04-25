
package compareString.springboot25042020;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner{
    private UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("username1", "password1");
        User user2 = new User("username2", "password2");
        
        this.userRepository.deleteAll();
       List<User> users = Arrays.asList(user1,user2);
       this.userRepository.saveAll(users);
        //this.userRepository.save(user1);
        //this.userRepository.save(user2);
    }
}
