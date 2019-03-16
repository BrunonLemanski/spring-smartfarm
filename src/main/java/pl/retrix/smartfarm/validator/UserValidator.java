package pl.retrix.smartfarm.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.retrix.smartfarm.domain.accounts.User;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass); //porownywanie obiektu User do obiektu zapisanego juz w bazie
    }

    @Override
    public void validate(Object object, Errors errors) {

        User user = (User) object;

        if(user.getPassword().length() < 6){
            errors.rejectValue("password", "Lenght", "Password must be at least 6 characters");
        }

        //Nie możemy używac porownania jak w c++ u pankiego '==' bo to znaczy porownanie w tej samej lokacji pamieci, nie ma opcji ze zadziala
        //  Wykorzystujemy za to obiektowa Jave czyli .equals()

        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Match", "Passwords must match");
        }
        //confirmPassword

    }
}
