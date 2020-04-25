
package compareString.springboot25042020;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/all")
    public List<User>getAll(){
        List<User>users=this.userRepository.findAll();
        return users;
    }
    
    @PostMapping("/match")
    public Boolean match(String username, String password){
    User tempUser =this.userRepository.findByUsername(username);
    if(tempUser.password.equals(password)){
        return true;
    }
    else return false;
   // List<User>users= this.userRepository.find( { $and: [ { username: { $ne: 1.99 } }, { password: { $exists: true } } ] } );
     // User temp = this.userRepository.find({ $and: [ { username: "username1" }, { password: "password1" } ] } );
    }
   // userRepository.find( { $and: [  { user.id: id }, {user.username: username } ] } }) ;
        
}
