package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseMessageDTO;
import tech.inovasoft.inevolving.api.domain.dto.response.UserEmailDTO;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<UserEmailDTO> getUsersIsVerifiedAndActive() {
        List<User> users = userRepository.getUsersIsVerifiedAndActive();

        return users.stream()
                .map(UserEmailDTO::new)
                .collect(Collectors.toList());
    }

    public List<UserEmailDTO> getUsersDisconnectedAndActive() {
        List<User> users = userRepository.getUsersDisconnectedAndActive();

        return users.stream()
                .map(UserEmailDTO::new)
                .collect(Collectors.toList());
    }
}
