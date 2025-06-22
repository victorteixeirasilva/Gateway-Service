package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseMessageDTO;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepository;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseMessageDTO confirmEmail(UUID idUser) {
        User user = userRepository.findById(idUser);
        user.setEmailVerified(true);
        userRepository.saveInDatabase(user);
        return new ResponseMessageDTO("Email confirmed");
    }
}
