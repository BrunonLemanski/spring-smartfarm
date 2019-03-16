package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.accounts.User;
import pl.retrix.smartfarm.exceptions.UsernameAlreadyExistException;
import pl.retrix.smartfarm.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser){
        try {

        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        //Usernamer has to be unique(exception)
            newUser.setUsername(newUser.getUsername()); //linijka sprawdzajaca czy w bazie jest user o nazwie podanej przez uzytkownika
//TODO: W podobny sposob beda tworzone metody sprawdzajace dla innych klas
        //Make sure that password and confirmPassword match

            //We don't persist or show the confirmPassword
            newUser.setConfirmPassword("");
            return userRepository.save(newUser);
        }catch (Exception e){
            throw new UsernameAlreadyExistException("Username '" + newUser.getUsername() + "' already exists"); //Message which show when HTTP have BAD_STATUS
        }
    }
}
